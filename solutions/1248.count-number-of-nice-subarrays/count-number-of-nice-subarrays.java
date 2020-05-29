class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int N=nums.length;
        int[] odds=new int[N+2];
        int cnt=0;
        odds[cnt++]=-1;
        for(int i=0;i<N;i++){
            if((nums[i]&1)==1) odds[cnt++]=i;
        }
        odds[cnt]=N;
        int res=0;
        for(int i=1;i+k<=cnt;i++){
            res+=(odds[i]-odds[i-1])*(odds[i+k]-odds[i+k-1]);
        }
        return res;
    }
}