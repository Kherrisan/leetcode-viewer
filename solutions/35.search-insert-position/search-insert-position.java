class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,N=nums.length,r=nums.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]<target){
                l=m+1;
            }else if(nums[m]>target){
                r=m-1;
            }else{
                return m;
            }
        }
        return l;
    }
}