class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if (minHeap.peek() < num) {
                    minHeap.poll();
                    minHeap.add(num);
                } else {

                }
            }
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}
