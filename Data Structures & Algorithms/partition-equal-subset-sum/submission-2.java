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
        Boolean[][] memo = new Boolean[nums.length][target+1];
        return dfs(nums, 0, target, memo);
    }
    
    boolean dfs(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (index >= nums.length) {
            return false;
        }
        if (memo[index][target] != null) {
            return memo[index][target];
        }

        boolean result = dfs(nums, index + 1, target, memo) || dfs(nums, index + 1, target - nums[index], memo);
        memo[index][target] = result;
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
