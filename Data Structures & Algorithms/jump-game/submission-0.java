class Solution {
    public boolean canJump(int[] nums) {
        
        int i = 0;
        int jump = nums[i];
        return dfs(nums, 0);
    }

    boolean dfs(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }
        int canJump = nums[i];
        int end = Math.min(nums.length - 1, i + canJump);
        for (int j = i + 1; j <= end; j++) {
            if (dfs(nums, j)) {
                return true;
            }
        }

        return false;

    }
}
