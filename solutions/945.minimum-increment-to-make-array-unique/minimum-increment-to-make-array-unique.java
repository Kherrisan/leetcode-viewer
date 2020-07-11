class Solution {
    public int minIncrementForUnique(int[] A) {
        int[] hash=new int[80000];
        int move=0;
        for(int i=0;i<80000;i++){
            hash[i]=-1;
        }
        for(int a:A){
            int pos = findPos(hash,a);
            move+=pos-a;
        }
        return move;
    }

    int findPos(int[] hash,int t){
        if(hash[t]==-1){
            hash[t]=t;
            return t;
        }
        hash[t]=findPos(hash,hash[t]+1);
        return hash[t];
    }
}