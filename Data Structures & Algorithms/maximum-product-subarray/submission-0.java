class Solution {
    public int maxProduct(int[] nums) {
        // get all subarrays
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length+1; j++) {
                max = Math.max(max, maxProduct(nums, i, j));
            }
        }
        return max;
    }

    private int maxProduct(int[] nums, int i, int j) {
        int product = 1;
        for (int a = i; a < j; a++) {
            product *= nums[a];
        }
        return product;
    }
}
