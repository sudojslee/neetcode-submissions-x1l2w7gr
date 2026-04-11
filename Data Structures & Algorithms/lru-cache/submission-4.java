class LRUCache {

    static class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head; // dummy head
    Node tail; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        // remove
        // insertAtHead
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.value = value;
            remove(existing);
            insertAtHead(existing);
            
            return;
        }

        if (capacity == 0) {
            return;
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insertAtHead(newNode);
        map.put(key, newNode);
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    void insertAtHead(Node node) {
        Node first = head.next;
        
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
    }
}
