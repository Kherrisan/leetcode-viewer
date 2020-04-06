class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0){
            return word2.length();
        }
        if(word2.length()==0){
            return word1.length();
        }
        int m=word1.length();
        int n=word2.length();
        int[][] d=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            d[i][0]=i;
        }
        for(int i=0;i<n+1;i++){
            d[0][i]=i;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                int l=d[i-1][j]+1;
                int r=d[i][j-1]+1;
                int k=d[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    k++;
                }
                d[i][j]=Math.min(Math.min(l,r),k);
            }
        }
        return d[m][n];
    }
}