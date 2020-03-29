class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int[] tailOfSeqWithLength = new int[nums.length];
        int len=0;
        for(int i:nums){
            if(len==0||i>tailOfSeqWithLength[len-1]){
                tailOfSeqWithLength[len++]=i;
            }else{
                int left=0;
                int right=len-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(tailOfSeqWithLength[mid]<i){
                        left=mid+1;
                    }else if(i<tailOfSeqWithLength[mid]){
                        right=mid-1;
                    }else{
                        left=mid;
                        break;
                    }
                }
                tailOfSeqWithLength[left]=i;
            }
        }
        return len;
    }
}