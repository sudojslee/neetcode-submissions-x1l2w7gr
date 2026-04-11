class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int longestConsecutive = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // if (set.contains(num - 1)) {
            //     continue;
            // }
            
            int current = 0;
            while (set.contains(num)) {
                current++;
                num++;
            }
            longestConsecutive = Math.max(current, longestConsecutive);
        }

        return longestConsecutive;
        
    }
}
