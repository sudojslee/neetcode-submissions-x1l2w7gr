class Solution {
    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(nums, 0, memo);
    }

    boolean dfs(int[] nums, int i, Map<Integer, Boolean> memo) {
        if (i == nums.length - 1) {
            return true;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int canJump = nums[i];
        int end = Math.min(nums.length - 1, i + canJump);
        for (int j = i + 1; j <= end; j++) {
            if (dfs(nums, j, memo)) {
                memo.put(i, true);
                return true;
            }
        }

        memo.put(i, false);
        return false;

    }
}
