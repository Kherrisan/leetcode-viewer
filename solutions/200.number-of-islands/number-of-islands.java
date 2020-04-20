class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                res+=islands(grid,i,j)?1:0;
            }
        }
        return res;
    }

    boolean islands(char[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return false;
        }else if(grid[i][j]=='2'||grid[i][j]=='0'){
            return false;
        }else{
            grid[i][j]='2';
            islands(grid,i-1,j);
            islands(grid,i+1,j);
            islands(grid,i,j-1);
            islands(grid,i,j+1);
            return true;
        }
    }
}