class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        int[] robFirst = new int[nums.length];
        int[] robSecond = new int[nums.length];
        robFirst[0] = nums[0];
        robFirst[1] = nums[0];
        robSecond[0] = 0;
        robSecond[1] = nums[1]; 

        int n = nums.length;
        for (int i = 2; i < nums.length; i++) {
            if (i == n - 1) {
                robFirst[i] = robFirst[i-1];
            } else {
                robFirst[i] = Math.max(robFirst[i-1], robFirst[i-2] + nums[i]);
            }
            
            robSecond[i] = Math.max(robSecond[i-1], robSecond[i-2] + nums[i]);
        }

        
        return Math.max(robFirst[n-1], robSecond[n-1]);

        // robFirst -> cannot rob last house (n-1)
        // robSecond -> can rob last house (n-1)
    }
}
