class Solution {
    public String compressString(String S) {
        if(S==null||S.length()<=2){
            return S;
        }
        StringBuilder b=new StringBuilder();
        char cur='0';
        int s=0;
        for(char ch:S.toCharArray()){
            if(cur=='0'){
                cur=ch;
                s=1;
            }else if(cur==ch){
                s++;
            }else{
                b.append(cur).append(s);
                cur=ch;
                s=1;
            }
        }
        b.append(cur).append(s);
        if(b.length()>=S.length()){
            return S;
        }else{
            return b.toString();
        }
    }
}