import java.lang.Integer.max


class Solution {
    fun canJump(nums: IntArray): Boolean {
        var right=0;
        for(i in nums.indices){
            //如果 i 已经脱离了 right，那就说明失败了
            if(i<=right){
                right=max(right,i+nums[i])
                if(right>=nums.size-1){
                    return true;
                }
            }
        }
        return false;
    }
}