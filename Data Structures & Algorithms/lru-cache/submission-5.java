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
    Node head;
    Node tail;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node(-1, -1); // dummy
        this.tail = new Node(-1, -1); // dummy

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAfterHead(node);
        // insert it back to the head;
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.value = value;

            remove(existing);
            insertAfterHead(existing);
            // insert it back to the head;
            return;
        }

        if (this.capacity == 0) {
            return;
        }

        if (map.size() >= this.capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        // add
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfterHead(newNode);
        
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    void insertAfterHead(Node node) {
        Node first = head.next;

        head.next = node;
        node.next = first;

        node.prev = head;
        first.prev = node;
    }

}
