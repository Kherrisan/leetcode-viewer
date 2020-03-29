'use strict'
const buildConf = require('../build.conf.js')
const path = require('path')
const sourcePath = path.resolve(__dirname, '../', buildConf.sourcePath)
const resultPath = path.resolve(sourcePath, 'result.json')
let result = require(resultPath)

// let formatId = require('./utils').formatId
let co = require('co')
let fs = require('fs')
let thenifyAll = require('thenify-all')
let thenFs = thenifyAll(fs, {}, ['readFile', 'writeFile'])

let chalk = require('chalk')
let log4js = require('log4js')
log4js.configure({
  appenders: [{
    type: 'console',
    layout: {
      type: 'pattern',
      pattern: `[%r] ${chalk.blue('[leetcode-viewer]')} %[%p%] - %m`
    }
  }]
})
let logger = log4js.getLogger('layout-pattern')

let languageExt = require('./language_ext')

let databaseGenPromiseFactory = co.wrap(function* (dirPath, frontendId, title, languageArr) {
  let database = {}
  languageArr.forEach((language) => {
    database[language] = thenFs.readFile(path.resolve(dirPath, `${frontendId}.${title}`, `${title}.${languageExt[language]}`))
      //.then((data) => escape(data))
      .then((data) => data + '')
      .catch(err => {
        logger.error(`error happens when reading ${frontendId}.${title}'s source code file: ${title}.${languageExt[language]}`)
        throw err
      })
  })
  database['frontendId'] = frontendId
  database['title'] = title
  return yield database
})

let databaseWritePromiseFactory = co.wrap(function* (dirPath, frontendId, title, databaseObj) {
  delete databaseObj['title']
  delete databaseObj['frontendId']
  return thenFs.writeFile(path.resolve(dirPath, `${frontendId}.${title}`, `db.json`), JSON.stringify(databaseObj))
    .catch(err => {
      logger.error(`error happens when writing ${frontendId}.${title}'s json file`)
      throw err
    })
})

co(function* () {
  let databasePromises = []
  Object.keys(result).forEach(frontendId => {
    try{
      if (!('id' in result[frontendId])) return
    }catch{
      return
    }
    if (result[frontendId].generated) {
      return
    }
    databasePromises.push(databaseGenPromiseFactory(sourcePath, frontendId, result[frontendId].title, result[frontendId].language))
    result[frontendId].generated = true
  })
  if (!databasePromises.length) return
  let databaseObjs = []
  try {
    databaseObjs = yield databasePromises
  } catch (e) {
    throw e
  }
  let databaseWritePromises = []
  databaseObjs.forEach(databaseObj => {
    databaseWritePromises.push(databaseWritePromiseFactory(sourcePath, databaseObj.frontendId, databaseObj.title, databaseObj))
  })
  try {
    yield databasePromises
    yield thenFs.writeFile(resultPath, JSON.stringify(result))
  } catch (e) {
    throw e
  }
  logger.info('generating finished')
}).catch(err => {
  logger.error(err)
  logger.error(err.stack)
  process.exit()
})
