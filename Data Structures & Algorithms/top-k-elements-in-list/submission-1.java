class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (int key : freq.keySet()) {
            list.add(new int[]{key, freq.get(key)});
        }

        Collections.sort(list, (a, b) -> b[1] - a[1]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[0];
        }
        return result;
    }
}
