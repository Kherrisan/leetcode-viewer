class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> counts1=new HashMap();
        for(int n:nums1){
            counts1.put(n,counts1.getOrDefault(n,0)+1);
        }
        Map<Integer,Integer> counts2=new HashMap();
        for(int n:nums2){
            counts2.put(n,counts2.getOrDefault(n,0)+1);
        }
        Map<Integer,Integer> resCounts=new HashMap();
        for(int n:counts1.keySet()){
            if(counts2.containsKey(n)){
                resCounts.put(n,Math.min(counts1.get(n),counts2.get(n)));
            }
        }
        List<Integer> res=new ArrayList();
        for(int n:resCounts.keySet()){
            int c=resCounts.get(n);
            while(c>0){
                res.add(n);
                c--;
            }
        }
        int[] rres=new int[res.size()];
        for(int i=0;i<res.size();i++){
            rres[i]=res.get(i);
        }
        return rres;
    }
}