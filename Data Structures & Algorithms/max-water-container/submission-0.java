class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int area = height * (right - left);
            maxArea = Math.max(area, maxArea);
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }


        return maxArea;
    }
}
