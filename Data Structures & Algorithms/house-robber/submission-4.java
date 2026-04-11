class Solution {
    int[] memo; 

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        int res =  Math.max(dfs(nums, i+1), nums[i] + dfs(nums, i + 2));
        memo[i] = res;
        return res;
    }

}
