class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        if(grid.length==0){
            return 0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                res=Math.max(helper(grid,i,j),res);
            }
        }
        return res;
    }

    private int helper(int[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==1){
            grid[i][j]=-1;
            return 1+helper(grid,i-1,j)+helper(grid,i+1,j)+helper(grid,i,j-1)+helper(grid,i,j+1);
        }
        return 0;
    }
}