/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> oldToNew = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (oldToNew.containsKey(head)) {
            return oldToNew.get(head);
        }

        Node newNode = new Node(head.val);
        oldToNew.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}
