class Solution {
    public int jump(int[] nums) {
        int end=0,maxPos=0,N=nums.length,jumps=0;
        for(int i=0;i<N-1;i++){
            maxPos=Math.max(maxPos,i+nums[i]);
            if(i==end){
                end=maxPos;
                jumps++;
            }
        }
        return jumps;
    }
}