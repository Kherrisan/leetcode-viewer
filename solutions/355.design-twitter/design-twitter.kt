var globalTime = 1

data class Tweet(val tid: Int, val userId: Int, val time: Int = globalTime++)

fun main() {
    Twitter()
}

class Twitter() {

    /** Initialize your data structure here. */
    private val followeeOf: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    private val followerOf: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    private val tweetFrom: MutableMap<Int, MutableList<Tweet>> = mutableMapOf()

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        tweetFrom.getOrPut(userId) { mutableListOf() }.add(Tweet(tweetId, userId))
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {
        followeeOf.getOrPut(userId) { mutableSetOf() }.add(userId)
        return followeeOf[userId]!!
            .map { tweetFrom.getOrPut(it) { mutableListOf() } }
            .fold(mutableSetOf<Tweet>()) { acc, tweets -> acc.addAll(tweets);acc }
            .sortedByDescending { it.time }
            .take(10)
            .map { it.tid }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        followerOf.getOrPut(followeeId) { mutableSetOf() }.add(followerId)
        followeeOf.getOrPut(followerId) { mutableSetOf() }.add(followeeId)
        followeeOf[followerId]!!.add(followerId)
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        followerOf.getOrPut(followeeId) { mutableSetOf() }.remove(followerId)
        followeeOf.getOrPut(followerId) { mutableSetOf() }.remove(followeeId)
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */