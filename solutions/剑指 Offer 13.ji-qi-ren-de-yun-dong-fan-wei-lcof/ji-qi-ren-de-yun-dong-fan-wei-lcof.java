class Solution {
    public int movingCount(int m, int n, int k) {
        return reachableCount(new int[m][n],0,0,k);
    }

    int reachableCount(int[][] reachable,int x,int y,int k){
        if(x<0||x>=reachable.length||y<0||y>=reachable[0].length){
            return 0;
        }
        if(!coordinateConstraint(x,y,k)||reachable[x][y]==-1){
            return 0;
        }else if(reachable[x][y]==0){
            reachable[x][y]=1;
            int count=1+reachableCount(reachable,x-1,y,k)+
                reachableCount(reachable,x+1,y,k)+
                reachableCount(reachable,x,y-1,k)+
                reachableCount(reachable,x,y+1,k);
            return count;
        }
        return 0;
    }

    boolean coordinateConstraint(int x,int y,int k){
        int res=0;
        while(x>0){
            res+=(x%10);
            x/=10;
        }
        while(y>0){
            res+=(y%10);
            y/=10;
        }
        return res<=k;
    }
}