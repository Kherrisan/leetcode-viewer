/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet();
        ListNode res = null;
        ListNode cursor = res;
        while(head != null){
            if(res == null){
                cursor = res = new ListNode(head.val);
                set.add(head.val);
            }else if(!set.contains(head.val)){
                cursor.next = new ListNode(head.val);
                cursor = cursor.next;
                set.add(head.val);
            }
            head = head.next;
        }
        return res;
    }   
}