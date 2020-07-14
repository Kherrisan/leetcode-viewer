import java.util.*;

class Node {
    int x;
    int y;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    int[][] nd=new int[][]{new int[]{1,0},new int[]{-1,0},new int[]{0,1},new int[]{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        int N=matrix.length;
        int M=matrix[0].length;
        int[][] res=new int[N][M];
        Queue<Node> q=new LinkedList();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]==0){
                    matrix[i][j]=-1;
                    res[i][j]=0;
                    q.offer(new Node(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Node n=q.poll();
            for(int i=0;i<4;i++){
                int x=n.x+nd[i][0];
                int y=n.y+nd[i][1];
                if(x>=0&&x<N&&y>=0&&y<M&&matrix[x][y]!=-1){
                    res[x][y]=res[n.x][n.y]+1;
                    q.offer(new Node(x,y));
                    matrix[x][y]=-1;
                }
            }
        }
        return res;
    }
}