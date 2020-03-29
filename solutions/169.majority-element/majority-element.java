class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int major=0;
        boolean start=true;
        int majorNums = 0;
        for(int i:nums){
            if(start){
                major=i;
                majorNums=1;
                start=false;
            }else if(major==i){
                majorNums++;
            }else{
                majorNums--;
                if(majorNums<0){
                    majorNums=1;
                    major=i;
                }
            }
        }
        return major;
    }
}