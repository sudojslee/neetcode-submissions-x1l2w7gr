class LRUCache {

    static class Node {
        int key;
        int value;
        
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertToFront(node);
            // remove node
            // insert to head
            return node.value;
        }
        
        return -1;        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.value = value;
            remove(existing);
            insertToFront(existing);
            // remove
            // insert to head
            return;
        }

        if (capacity == 0) {
            return;
        }

        // System.out.println("put: " + value);

        if (capacity == map.size()) {
            Node last = tail.prev;
            // System.out.println("removing: " + last.value);
            remove(last);
            map.remove(last.key);
            // remove tail
            // remove in map
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertToFront(newNode);
    }

    void insertToFront(Node node) {
        Node front = head.next;

        head.next = node;
        node.next = front;
        
        front.prev = node;
        node.prev = head;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}
