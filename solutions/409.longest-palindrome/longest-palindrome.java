class Solution {
    public int longestPalindrome(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int[] charSet=new int[52];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a'){
                charSet[s.charAt(i)-'a']++;
            }else{
                charSet[26+s.charAt(i)-'A']++;
            }
        }
        int res=0;
        for(int i=0;i<52;i++){
            res+=charSet[i]/2*2;
            if(charSet[i]%2==1 && res%2==0){
                res++;
            }
        }   
        return res;
    }
}