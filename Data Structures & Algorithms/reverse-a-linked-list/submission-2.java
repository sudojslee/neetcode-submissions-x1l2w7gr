/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        ListNode newHead = list.get(list.size() - 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode current = list.get(i);
            ListNode next;
            if (i-1 >= 0) {
                next = list.get(i-1);
            } else {
                next = null;
            }
            current.next = next;
            
        }

        return newHead;
    }
}
