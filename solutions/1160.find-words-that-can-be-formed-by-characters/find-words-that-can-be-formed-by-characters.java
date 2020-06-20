class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] dictionary = new int[26];
        for(char ch:chars.toCharArray()){
            dictionary[ch-'a']++;
        }
        int res=0;
        boolean learned=true;
        int[] counter = new int[26];
        for(String w:words){
            learned=true;
            for(char ch:w.toCharArray()){
                counter[ch-'a']++;
                if(counter[ch-'a']>dictionary[ch-'a']){
                    learned=false;
                    break;
                }
            }
            if(learned){
                res+=w.length();
            }
            for(int i=0;i<26;i++){
                counter[i]=0;
            }
        }
        return res;
    }
}