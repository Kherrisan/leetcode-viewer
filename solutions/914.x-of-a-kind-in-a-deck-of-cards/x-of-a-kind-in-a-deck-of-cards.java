class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] counter=new int[10000];
        for(int d : deck) counter[d]++;
        int d=0;
        for(int i=0;i<10000;i++){
            if(counter[i]!=0 && d==0)d=counter[i];
            else if(counter[i]!=0) d = gcd(d,counter[i]);
        }
        return d>1;
    }

    private int gcd(int x,int y){
        if(x<y){
            int tmp=x;
            x=y;
            y=tmp;
        }
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }
}