class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[0] = height[0];
        maxRight[maxRight.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
            maxRight[height.length - i - 1] = Math.max(height[height.length - i - 1], maxRight[height.length - i]);
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int pot = Math.min(maxLeft[i], maxRight[i]);
            int area = pot - height[i];
            if (area > 0) {
                result += area;
            }
        }

        // System.out.println(Arrays.toString(maxLeft));
        // System.out.println(Arrays.toString(maxRight));
        return result;
    }
}
