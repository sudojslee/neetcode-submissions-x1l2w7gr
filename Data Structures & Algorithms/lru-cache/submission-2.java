class LRUCache {

    int capacity;
    Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if (cache.size() < this.capacity) {
            cache.put(key, value);
            return;
        }
        
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        
        int i = 0;
        int toRemove = 0;
        for (int k : cache.keySet()) {
            // first element
            if (i == 0) {
                toRemove = k;
                break;
            }
        }
        cache.remove(toRemove);
        cache.put(key, value);
    }
}
