class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2){
            return n;
        }
        int x=1,y=2;
        int res=1;
        for(int i=2;i<n;i++){
            res=x+y;
            x=y;
            y=res;
        }
        return res;
    }
}