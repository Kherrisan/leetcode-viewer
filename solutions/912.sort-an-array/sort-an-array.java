class Solution {
    public int[] sortArray(int[] nums) {
        int[] place=new int[100000];
        for(int n:nums){place[n+50000]++;}
        int[] result=new int[nums.length];
        int k=0;
        for(int i=0;i<100000;i++){
            while(place[i]>0){
                result[k++]=i-50000;
                place[i]--;
            }
        }
        return result;
    }
}