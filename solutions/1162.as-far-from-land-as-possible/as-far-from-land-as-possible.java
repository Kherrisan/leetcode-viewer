class Solution {
    public int maxDistance(int[][] grid) {
        int M=grid.length;int N=grid[0].length;
        Queue<Integer> queue = new LinkedList();
        int[] dx=new int[]{1,0,0,-1};
        int[] dy=new int[]{0,1,-1,0};
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==1){
                    queue.offer(i);
                    queue.offer(j);
                }
            }
        }
        int last=0;
        boolean hasOcean=false;
        while(!queue.isEmpty()){
            int x=queue.poll();
            int y=queue.poll();
            for(int i=0;i<4;i++){
                int newX=dx[i]+x;
                int newY=dy[i]+y;
                if(newX<0||newX>=M||newY<0||newY>=N||grid[newX][newY]!=0){
                    continue;
                }
                grid[newX][newY]=grid[x][y]+1;
                last=grid[newX][newY];
                hasOcean=true;
                queue.offer(newX);
                queue.offer(newY);
            }
        }
        return hasOcean?last-1:-1;
    }
}