class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }

            // else
            int curr = 0;
            while (set.contains(num)) {
                num++;
                curr++;
            }
            longest = Math.max(longest, curr);
        }

        return longest;
    }
}
