class Solution {
    boolean result = false;
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        backtrack(nums, 0, target, 0);
        return result;
    }

    void backtrack(int[] nums, int index, int target, int currentSum) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            result = true;
            return;
        }
        if (index >= nums.length) {
            return;
        }

        // choose nums[index]
        backtrack(nums, index + 1, target, currentSum + nums[index]);

        // do not choose nums[index]
        backtrack(nums, index + 1, target, currentSum);
    }
}
