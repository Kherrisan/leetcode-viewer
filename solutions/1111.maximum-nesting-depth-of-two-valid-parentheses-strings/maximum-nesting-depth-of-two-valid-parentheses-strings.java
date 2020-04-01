class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res=new int[seq.length()];
        int resi=0;
        int depth=0;
        for(char c: seq.toCharArray()){
            if(c=='('){
                res[resi++]=++depth%2;
            }else{
                res[resi++]=depth--%2;
            }
        }
        return res;
    }
}