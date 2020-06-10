class Solution {
    public boolean isPalindrome(int x) {
        String val = ""+x;
        int left=0,right=val.length()-1;
        while(left<right){
            if(val.charAt(left)!=val.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}