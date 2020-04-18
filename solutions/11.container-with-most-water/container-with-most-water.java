class Solution {
    public int maxArea(int[] height) {
        int size=height.length;
        int left=0;
        int right=size-1;
        int res=0;
        while(left<right){
            res=Math.max(res,(right-left)*Math.min(height[left],height[right]));
            if(height[left]>height[right])
                right--;
            else
                left++;
        }
        return res;
    }
}