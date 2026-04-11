class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            for (int j = i; j < heights.length; j++) {
                height = Math.min(height, heights[j]);
                int area = height * (j - i + 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}
