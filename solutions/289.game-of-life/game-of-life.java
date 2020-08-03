class Solution {
    public void gameOfLife(int[][] board) {
        int[][] res=new int[board.length][];
        for(int i=0;i<res.length;i++){
            res[i]=new int[board[0].length];
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                res[i][j]=board[i][j];
                int surrounding=surroundingAlive(board,i,j);
                if(board[i][j]==1 && (surrounding<2||surrounding>3)){
                    res[i][j]=0;
                }else if(board[i][j]==0 && surrounding==3){
                    res[i][j]=1;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            board[i]=res[i];
        }
    }

    public int surroundingAlive(int[][] b,int i,int j){
        return count(b,i-1,j)+count(b,i+1,j)+count(b,i-1,j-1)
            +count(b,i,j-1)+count(b,i,j+1)+count(b,i-1,j+1)
            +count(b,i+1,j-1)+count(b,i+1,j+1);
    }

    public int count(int[][] b,int i,int j){
        if(i<0||i>=b.length||j<0||j>=b[0].length){
            return 0;
        }
        return b[i][j];
    }
}