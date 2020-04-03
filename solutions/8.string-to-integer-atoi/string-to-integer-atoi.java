class Solution {
    public int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        char[] chs = str.toCharArray();
        int ceiling= Integer.MAX_VALUE/10;
        int res=0;
        int trimedStart=0;
        for(;trimedStart<chs.length;trimedStart++){
            if(chs[trimedStart]!=' '){
                break;
            }
        }
        boolean positive = false;
        if(trimedStart==chs.length){
            return 0;
        }
        if(chs[trimedStart]=='+'){
            positive=true;trimedStart++;
        }else if(chs[trimedStart]=='-'){
             positive=false;trimedStart++;
        }else{
             positive=true;
        }
        for(int i=trimedStart;i<chs.length;i++){
            if(chs[i]<'0'||chs[i]>'9'){
                break;
            }
            if(positive && res>ceiling){
                return Integer.MAX_VALUE;
            }else if(res>ceiling && !positive){
                return Integer.MIN_VALUE;
            }
            int d=chs[i]-'0';
            if(res==ceiling && positive && d>Integer.MAX_VALUE-ceiling*10){
                return Integer.MAX_VALUE;
            }else if(res==ceiling && !positive && d>-(ceiling*10+Integer.MIN_VALUE)){
                return Integer.MIN_VALUE;
            }
            res=res*10+d;
        }
        if(positive){
            return res;
        }
        return -res;
    }
}