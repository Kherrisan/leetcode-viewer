class Solution {
    public int surfaceArea(int[][] grid) {
        int cubes=0;
        int covers=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                cubes+=grid[i][j];
                if(grid[i][j]>1){
                    covers+=grid[i][j]-1;
                }
                if(i>0){
                    covers+=Math.min(grid[i-1][j],grid[i][j]);
                }
                if(j>0){
                    covers+=Math.min(grid[i][j-1],grid[i][j]);
                }
            }
        }
        return 6*cubes-covers*2;
    }
}