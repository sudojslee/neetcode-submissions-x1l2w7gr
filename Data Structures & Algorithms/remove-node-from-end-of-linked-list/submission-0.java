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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        int indexToRemove = length - n;

        if (indexToRemove == 0) {
            return head.next;
        }
        
        curr = head;
        for (int i = 0; i < indexToRemove; i++) {
            curr = curr.next;
        }

        ListNode nodeToRemove = curr;
        
        ListNode prev = head;
        for (int i = 0; i < indexToRemove-1; i++) {
            prev = prev.next;
        }

        if (nodeToRemove.next == null) {
            prev.next = null;
            return head;
        }

        prev.next = nodeToRemove.next;
        return head;
    }
}
