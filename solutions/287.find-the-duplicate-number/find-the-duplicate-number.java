class Solution {
    public int findDuplicate(int[] nums) {
        int N=nums.length;
        Random rand = new Random(System.currentTimeMillis());
        while(true){
            int i=rand.nextInt(N);
            int j=rand.nextInt(N);
            if(i==j){
                continue;
            }
            if(nums[i]==nums[j]){
                return nums[i];
            }
        }
    }
}