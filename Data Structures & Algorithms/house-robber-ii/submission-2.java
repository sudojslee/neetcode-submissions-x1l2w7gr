class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // [0:n-2]
        int[] first = new int[nums.length - 1];
        first[0] = nums[0];
        first[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < first.length; i++) {
            first[i] = Math.max(first[i-1], first[i-2] + nums[i]);
        }
        // [1:n-1]
        int[] second = new int[nums.length - 1];
        second[0] = nums[1];
        second[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < second.length; i++) {
            second[i] = Math.max(second[i-1], second[i-2] + nums[i+1]);
        }
        return Math.max(first[first.length -1], second[second.length - 1]);
    }
}
