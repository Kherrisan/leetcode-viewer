class Solution {
    public String addBinary(String a, String b) {
        int carry=0;
        StringBuilder res=new StringBuilder();
        int i=a.length()-1,j=b.length()-1;
        while(i>=0||j>=0){
            if(i<0){
                int t=Character.getNumericValue(b.charAt(j--));
                res.insert(0,(t+carry)%2);
                carry=(t+carry)/2;
            }else if(j<0){
                int t=Character.getNumericValue(a.charAt(i--));
                res.insert(0,(t+carry)%2);
                carry=(t+carry)/2;
            }else{
                int at=Character.getNumericValue(a.charAt(i--));
                int bt=Character.getNumericValue(b.charAt(j--));
                res.insert(0,(at+bt+carry)%2);
                carry=(at+bt+carry)/2;
            }
        }
        if(carry!=0){
            res.insert(0,carry);
        }
        return res.toString();
    }
}