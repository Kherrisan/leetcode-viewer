class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int res=nums[0];
        int sum=0;
        for(int n:nums){
            sum=Math.max(sum+n,n);
            res=Math.max(res,sum);
        }
        return res;
    }
}