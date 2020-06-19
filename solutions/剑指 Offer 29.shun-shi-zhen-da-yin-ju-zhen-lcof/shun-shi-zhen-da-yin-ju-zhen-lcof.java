class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int M=matrix.length;
        if(M==0){
            return new int[0];
        }
        int N=matrix[0].length;
        
        int[] res=new int[M*N];
        int cur=0;
        int offset=0;
        while(cur<res.length){
            for(int i=offset;i<N-offset;i++){
                res[cur++]=matrix[offset][i];
            }
            if(cur>=res.length){
                break;
            }
            for(int i=offset+1;i<M-offset;i++){
                res[cur++]=matrix[i][N-1-offset];
            }
            if(cur>=res.length){
                break;
            }
            for(int i=N-2-offset;i>=offset;i--){
                res[cur++]=matrix[M-1-offset][i];
            }
            if(cur>=res.length){
                break;
            }
            for(int i=M-2-offset;i>offset;i--){
                res[cur++]=matrix[i][offset];
            }
            offset++;
        }
        return res;
    }
}