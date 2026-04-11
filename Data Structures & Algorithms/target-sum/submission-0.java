class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        

        dfs(nums, 0, target);
        return result;
    }

    private void dfs(int[] nums, int index, int target) {
        if (nums.length == index && target == 0) {
            result++;
            return;
        }
        if (index >= nums.length) {
            return;
        }

        // add
        dfs(nums, index + 1, target - nums[index]);
        dfs(nums, index + 1, target + nums[index]);
        // subtract
    }
}
