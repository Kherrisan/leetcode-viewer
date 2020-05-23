class Solution {
    Map<Character,Integer> cnt = new HashMap();
    Map<Character,Integer> dct = new HashMap();
    public String minWindow(String s, String t) {
        int res=Integer.MAX_VALUE;
        int tl=t.length(),sl=s.length();
        for(int i=0;i<tl;i++){
            dct.put(t.charAt(i),dct.getOrDefault(t.charAt(i),0)+1);
        }
        int left=0,right=-1;
        int resL=0,resR=-1;
        while(right<sl){
            right++;
            if(right<sl&&dct.containsKey(s.charAt(right))){
                cnt.put(s.charAt(right),cnt.getOrDefault(s.charAt(right),0)+1);
            }
            while(left<=right&& check()){
                if(right-left+1<res){
                    res=right-left+1;
                    resL=left;
                    resR=right;
                }
                if(dct.containsKey(s.charAt(left))){
                    cnt.put(s.charAt(left),cnt.getOrDefault(s.charAt(left),0)-1);
                }
                left++;
            }
        }
        return resR==-1?"": s.substring(resL,resR+1);
    }

    boolean check(){
        for(char ch:dct.keySet()){
            if(!cnt.containsKey(ch)||cnt.get(ch)<dct.get(ch)){
                return false;
            }
        }
        return true;
    }
}