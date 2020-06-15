class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.isEmpty()) return ""
        val min=strs.min()!!
        val max=strs.max()!!
        for(i in min.indices){
            if(min[i]!=max[i]){
                return min.substring(0,i)
            }
        }
        return min
    }
}