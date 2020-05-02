class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.isEmpty()){
            return 0;
        }else if(s.trim().isEmpty()){
            return 1;
        }
        int maxSubstringLength=0;
        int[] indexOf=new int[128];
        int left=0,right=-1;
        for(int i=0;i<128;i++){
            indexOf[i]=-1;
        }
        while(right<s.length()-1){
            char ch=s.charAt(++right);
            if(indexOf[ch]!=-1){
                int newLeft=indexOf[ch]+1;
                for(int i=left;i<newLeft;i++){
                    indexOf[s.charAt(i)]=-1;
                }
                left=newLeft;
            }
            indexOf[ch]=right;
            maxSubstringLength=Math.max(maxSubstringLength,right-left+1);
        }
        return maxSubstringLength;
    }
}