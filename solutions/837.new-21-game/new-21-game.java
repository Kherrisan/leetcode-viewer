class Solution {
    public double new21Game(int N, int K, int W) {
        if (K==0) return 1.0;
        double[] dp=new double[K+W];
        double s=0;
        for(int i=K;i<K+W;i++){
            if(i<=N){
                dp[i]=1.0;
            }else{
                dp[i]=0.0;
            }
            s+=dp[i];
        }
        for(int i=K-1;i>=0;i--){
            dp[i]=s/W;
            s+=dp[i];
            s-=dp[i+W];
        }
        return dp[0];
    }
}