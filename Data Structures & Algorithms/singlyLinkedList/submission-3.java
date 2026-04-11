class LinkedList {

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (this.head == null) {
            return -1;
        }
        if (index >= size) {
            return -1;
        }

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        this.size++;    
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public boolean remove(int index) {
        if (this.head == null) {
            return false;
        }
        if (index >= size) {
            return false;
        }

        if (index == 0) {
            this.head = head.next;
            this.size--;
            return true;
        }

        
        Node nodeToRemove = this.head;
        for (int i = 0; i < index; i++) {
            nodeToRemove = nodeToRemove.next;
        }

        Node prev = this.head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        // tail node
        if (nodeToRemove.next == null) {
            prev.next = null;
            this.tail = prev;
        } else {
            prev.next = nodeToRemove.next;
        }

        this.size--;
    
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        
        Node current = this.head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        return values;

    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
