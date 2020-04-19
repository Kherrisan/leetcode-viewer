class Solution {
    fun reverseWords(s: String): String {
        //简简单单才是真
        return s.trim().split(Pattern.compile("\\s+")).reversed().joinToString(" ")
    }
}