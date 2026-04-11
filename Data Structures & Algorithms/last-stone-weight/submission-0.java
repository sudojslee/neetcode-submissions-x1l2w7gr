class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();

            int remainder = a - b;
            if (remainder != 0) {
                maxHeap.add(remainder);
            }
        }

        if (!maxHeap.isEmpty()) {
            return maxHeap.poll();
        }
        
        return 0;
        
    }
}
