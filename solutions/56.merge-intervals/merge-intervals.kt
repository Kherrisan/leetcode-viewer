import java.lang.Integer.max

fun main() {
    println()
}

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sorted = intervals.toList().sortedBy { it[0] }
        val res = mutableListOf<IntArray>()
        for (interval in sorted) {
            if (res.isEmpty() || res.last()[1] < interval[0]) {
                //[1,5],[10,12]
                res.add(interval)
            } else {
                //[1,5],[1,4/10]
                //[1,5]
                res.last()[1] = max(res.last()[1], interval[1])
            }
        }
        return res.toTypedArray()
    }
}