class Solution {
    public int massage(int[] nums) {
        int[] endOf=new int[nums.length];
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }
        endOf[0]=nums[0];
        endOf[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            endOf[i]=Math.max(endOf[i-1],endOf[i-2]+nums[i]);
        }
        return endOf[nums.length-1];
    }
}