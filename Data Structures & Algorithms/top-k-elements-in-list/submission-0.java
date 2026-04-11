class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 3->3, 2->2, 1->1
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            if (!freqMap.containsKey(num)) {
                freqMap.put(num, 1);
            } else {
                freqMap.put(num, freqMap.get(num) + 1);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for (int key : freqMap.keySet()) {
            pq.add(new int[]{key, freqMap.get(key)});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int[] arr = pq.poll();
            result[i] = arr[0];
        }
        
        return result;
    }
}
