class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num - 1)) {
                continue;
            }
            int length = 0;
            while (set.contains(num)) {
                num++;
                length++;
            }
           
            longest = Math.max(longest, length);
        }
        return longest;
    
    }
}
