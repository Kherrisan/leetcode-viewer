class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z){
            return false;
        }else if(x+y==z){
            return true;
        }
        if(x==0||y==0){
            return x+y==z||z==0;
        }
        return z%gcd(x,y)==0;
    }

    int gcd(int m,int n){
        if(m<n){
            int t=m;
            m=n;
            n=t;
        }
        if(m%n==0){
            return n;
        }
        return gcd(n,m%n);
    }
}