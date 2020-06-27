class Solution {
    public int firstMissingPositive(int[] nums) {
        int N=nums.length;
        for(int i=0;i<N;i++){
            if(nums[i]<=0){
                nums[i]=N+1;
            }
        }
        for(int i=0;i<N;i++){
            int n=Math.abs(nums[i]);
            if(n<=N){
                nums[n-1]=-Math.abs(nums[n-1]);
            }
        }
        for(int i=0;i<N;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return N+1;
    }
}