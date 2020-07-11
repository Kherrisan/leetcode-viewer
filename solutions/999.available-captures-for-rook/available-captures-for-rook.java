class Solution {
    public int numRookCaptures(char[][] board) {
        int res=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=='R'){
                    for(int d=1;i+d<8;d++){
                        if(board[d+i][j]=='B'){
                            break;
                        }else if(board[d+i][j]=='p'){
                            res++;
                            break;
                        }
                    }
                    for(int d=1;i-d>=0;d++){
                        if(board[i-d][j]=='B'){
                            break;
                        }else if(board[i-d][j]=='p'){
                            res++;
                            break;
                        }
                    }
                    for(int d=1;j-d>=0;d++){
                        if(board[i][j-d]=='B'){
                            break;
                        }else if(board[i][j-d]=='p'){
                            res++;
                            break;
                        }
                    }
                    for(int d=1;j+d<8;d++){
                        if(board[i][j+d]=='B'){
                            break;
                        }else if(board[i][j+d]=='p'){
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}