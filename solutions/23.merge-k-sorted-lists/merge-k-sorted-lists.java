/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
ListNode head = null;
        ListNode res = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                return listNode.val - t1.val;
            }
        });
        for (ListNode node : lists) {
            if(node!=null)
            pq.add(node);
        }
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            if (head == null) {
                head = new ListNode(n.val);
                res = head;
            } else {
                head.next = new ListNode(n.val);
                head = head.next;
            }
            n = n.next;
            if (n != null) {
                pq.offer(n);
            }
        }
        return res;
    }
}