class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer,Integer> map=new HashMap();
        int res=0,sum=0;
        map.put(0,1);
        for(int a:A){
            sum+=a;
            int m=(sum%K+K)%K;
            int c=map.getOrDefault(m,0);
            res+=c;
            map.put(m,c+1);
        }
        return res;
    }
}