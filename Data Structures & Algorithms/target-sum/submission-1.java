class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int index, int target) {
        if (nums.length == index && target == 0) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }

        // add
        return dfs(nums, index + 1, target - nums[index]) + dfs(nums, index + 1, target + nums[index]);
        // subtract
    }
}
