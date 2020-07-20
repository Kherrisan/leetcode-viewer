class Solution {
    public int respace(String[] dictionary, String sentence) {
        int[] dp=new int[sentence.length()+1];
        char[] chars=sentence.toCharArray();
        for(int i=1;i<=chars.length;i++){
            dp[i]=dp[i-1]+1;
            for(String word:dictionary){
                int wl=word.length();
                if(i-wl>=0 && sentence.substring(i-wl,i).equals(word)){
                    dp[i]=Math.min(dp[i-wl],dp[i]);
                }
            }
        }
        return dp[sentence.length()];
    }
}