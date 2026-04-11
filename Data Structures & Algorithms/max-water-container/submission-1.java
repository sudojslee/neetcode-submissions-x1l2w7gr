class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0;
        int r = heights.length - 1;

        int maxArea = 0;

        while (l < r) {
            int leftHeight = heights[l];
            int rightHeight = heights[r];
            int height = Math.min(leftHeight, rightHeight);
            int area = (r - l) * height;
            maxArea = Math.max(area, maxArea);
            if (leftHeight > rightHeight) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
