class Solution {
    public int minimumLengthEncoding(String[] words) {
        Comparator<String> cmpor = (s1,s2)->{
            int i1=s1.length()-1;
            int i2=s2.length()-1;
            for(;i1>=0&&i2>=0;i1--,i2--){
                if(s1.charAt(i1)!=s2.charAt(i2)){
                    return s1.charAt(i1)-s2.charAt(i2);
                }
            }
            return i1-i2;
        };
        Arrays.sort(words,cmpor);
        int length=0;
        for(int i=1;i<words.length;i++){
            if(!words[i].endsWith(words[i-1])){
                length+=(1+words[i-1].length());
            }
        }
        length+=(1+words[words.length-1].length());
        return length;
    }
}