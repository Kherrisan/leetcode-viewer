class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet();
        while(!set.contains(n)){
            set.add(n);
            System.out.println(n);
            int happy=0;
            while(n>0){
                int d=n%10;
                n/=10;
                happy+=d*d;
            }
            if(happy==1){
                return true;
            }else{
                n=happy;
            }
        }
        return false;
    }
}