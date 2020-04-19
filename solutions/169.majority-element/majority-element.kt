class Solution {
    fun majorityElement(nums: IntArray): Int {
        if(nums.size==0){
            return 0
        }else if(nums.size==1){
            return nums[0]
        }
        var major:Int? = null
        var majorNums = 0
        for(i in nums){
            if(major == null){
                major = i
                majorNums = 1
            }else if(major == i){
                majorNums +=1
            }else{
                majorNums -= 1
                if(majorNums<0){
                    majorNums=1
                    major=i
                }
            }
        }
        return major!!
    }
}