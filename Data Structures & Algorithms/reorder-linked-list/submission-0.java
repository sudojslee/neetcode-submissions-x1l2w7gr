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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        System.out.println(list.size());

        curr = head;
        for (int i = 0; i < list.size(); i++) {
            // head 
            if (i == 0) continue;

            if (i % 2 == 0) {
                curr.next = list.get(i / 2);
                
            } else {
                curr.next = list.get(list.size() - 1 - i / 2);
            }
            curr = curr.next;

        }
        curr.next = null;
    }
}
