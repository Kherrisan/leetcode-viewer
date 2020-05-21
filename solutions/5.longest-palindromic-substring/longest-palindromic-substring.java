class Solution {
    public String longestPalindrome(String s) {
        int N=s.length();
        boolean[][] dp =new boolean[N][N];
        char[] ch=s.toCharArray();
        String res="";
        for(int l=0;l<N;l++){
            for(int i=0;i<N;i++){
                int j=i+l;
                if(j>=N){
                    break;
                }
                if(l==0){
                    dp[i][j]=true;
                }else if(l==1){
                    dp[i][j]=ch[i]==ch[j];
                }else{
                    dp[i][j]=dp[i+1][j-1]&&(ch[i]==ch[j]);
                }
                if(dp[i][j]&&l+1>res.length()){
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}