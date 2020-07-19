class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N=nums.length;
        int[] res=new int[N];
        res[0]=1;
        for(int i=1;i<N;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int a=1;
        for(int i=N-1;i>=0;i--){
            res[i]=res[i]*a;
            a*=nums[i];
        }
        return res;
    }
}