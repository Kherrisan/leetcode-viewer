class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(n>=0){
            return pow(x,N);
        }else{
            return 1/pow(x,-N);
        }
    }

    double pow(double x,long n){
        if(n==0){
            return 1d;
        }
        double y=pow(x,n/2);
        if(n%2==1){
            return y*y*x;
        }else{
            return y*y;
        }
    }
}