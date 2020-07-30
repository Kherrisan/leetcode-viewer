class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        for(int i:candies){
            max=Math.max(i,max);
        }
        List<Boolean> list=new ArrayList();
        for(int i:candies){
            list.add(i+extraCandies>=max);
        }
        return list;
    }
}