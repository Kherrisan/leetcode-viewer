/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i=reverse(l1);
        ListNode j=reverse(l2);
        int carriage=0;
        ListNode res = null;
        ListNode itr = res;
        while(i!=null||j!=null){
            int acc=0;
            if(i==null){
                acc = j.val+carriage;
                j=j.next;
            }else if(j==null){
                acc = i.val+carriage;
                i=i.next;
            }else{
                acc = j.val+i.val+carriage;
                i=i.next;
                j=j.next;
            }
            if(itr==null){
                itr=new ListNode(acc%10);
                res=itr;
            }else{
                itr.next=new ListNode(acc%10);
                itr=itr.next;
            }
            carriage=acc/10;
        }
        if(carriage>0){
            itr.next=new ListNode(carriage);
        }
        return reverse(res);
    }

    public ListNode reverse(ListNode l){
        ListNode cursor=l,last = null;
        while(cursor!=null){
            ListNode next=cursor.next;
            cursor.next=last;
            last=cursor;
            cursor=next;
        }
        return last;
    }
}