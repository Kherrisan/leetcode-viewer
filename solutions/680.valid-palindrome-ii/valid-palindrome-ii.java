class Solution {
    public boolean validPalindrome(String s) {
        char[] ch=s.toCharArray();
        int i=0,j=s.length()-1;
        for(;i<j&&ch[i]==ch[j];i++,j--);
        return i>=j||isPalindrome(ch,i,j-1) || isPalindrome(ch,i+1,j);
    }

    boolean isPalindrome(char[] ch,int i,int j){
        while(i<j){
            if(ch[i++]!=ch[j--]){
                return false;
            }
        }
        return true;
    }
}