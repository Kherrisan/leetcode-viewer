/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        ListNode res = null;
        ListNode segmentHead;
        ListNode segmentTail = null;
        while(true){
            segmentHead = head;
            for(int i=0;i<k;i++){
                if(head == null){
                    return res;
                }
                head = head.next;
            }
            head = segmentHead;
            ListNode next;
            ListNode previous = null;
            for(int i=0;i<k;i++){
                next = head.next;
                head.next = previous;
                previous = head;
                head = next;
            }
            if(res == null){
                res = previous;
            }else{
                segmentTail.next = previous;
            }
            segmentTail = segmentHead;
            segmentTail.next = head;
        }
    }
}