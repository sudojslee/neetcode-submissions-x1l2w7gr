class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] includeFirst = new int[nums.length + 1];
        int[] includeSecond = new int[nums.length + 1];
        includeFirst[0] = nums[0];
        includeSecond[0] = 0;
        includeFirst[1] = nums[0];
        includeSecond[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            includeFirst[i] = Math.max(includeFirst[i-2] + nums[i], includeFirst[i-1]);
            includeSecond[i] = Math.max(includeSecond[i-2] + nums[i], includeSecond[i-1]);
        }
        
        return Math.max(includeFirst[nums.length - 2], includeSecond[nums.length - 1]);
        
    }
}
