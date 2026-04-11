class Solution {
    Map<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int index, int target) {
        if (nums.length == index && target == 0) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        String key = index + ":" + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = dfs(nums, index + 1, target - nums[index]) + dfs(nums, index + 1, target + nums[index]);
        memo.put(key, result);
        // memo[index][target] = result;
        // cache [index][target]
        return result;
        
    }
}
