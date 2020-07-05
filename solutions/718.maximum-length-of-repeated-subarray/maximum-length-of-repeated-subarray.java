class Solution {
    public int findLength(int[] A, int[] B) {
        int M = A.length,N = B.length;
        int[][] dp=new int[M+1][N+1];
        int local = 0;
        int res = 0;
        for(int i=1;i<M+1;i++){
            for(int j=1;j<N+1;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    local = Math.max(local,dp[i][j]);
                }
            }
            res = Math.max(local,res);
        }
        return res;
    }
}