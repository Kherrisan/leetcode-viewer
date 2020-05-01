/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode res=null;
        ListNode r=res;
        while(l1!=null||l2!=null){
            if(res==null){
                if(l1.val<l2.val){
                    res=l1;
                    r=res;
                    l1=l1.next;
                }else{
                    res=l2;
                    r=res;
                    l2=l2.next;
                }
            }else {
                if(l1==null){
                    res.next=l2;
                    l2=l2.next;
                }else if(l2==null){
                    res.next=l1;
                    l1=l1.next;
                }else if(l1.val<l2.val){
                    res.next=l1;
                    l1=l1.next;
                }else{
                    res.next=l2;
                    l2=l2.next;
                }
                res=res.next;
            }
        }
        return r;
    }
}