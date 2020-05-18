class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        //正整数必定是越乘越大的
        //就算遇到了负数也要继续乘下去
        int res=nums[0],max=nums[0],min=nums[0];
        for(int i=1;i<nums.length;i++){
            int m=max,n=min;
            max=Math.max(m*nums[i],Math.max(n*nums[i],nums[i]));
            min=Math.min(m*nums[i],Math.min(n*nums[i],nums[i]));
            res=Math.max(res,max);
        }
        return res;
    }
}