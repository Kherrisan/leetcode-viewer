class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int N=matrix.length-1;
        int l=matrix[0][0],r=matrix[N][N];
        while(l<r){
            int mid=l+(r-l)/2;
            if(countNoMoreThan(matrix,mid)<k){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return r;
    }

    int countNoMoreThan(int[][] m,int target){
        int x=m.length-1,y=0,count=0;
        while(x>=0&&y<=m.length-1){
            if(m[x][y]<=target){
                count+=x+1;
                y++;
            }else{
                x--;
            }
        }
        return count;
    }
}