class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // do something
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    if (maxArea < area) {
                        maxArea = area;
                    }
                }
            }
        }


        return maxArea;
    }

    int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i > grid.length - 1) {
            return 0;
        }

        if (j < 0 || j > grid[0].length - 1) {
            return 0;
        }
    
        if (grid[i][j] != 1) {
            return 0;
        }

        // mark as visited
        grid[i][j] = 2;

        int area = 1;
        area += dfs(i-1, j, grid);
        area += dfs(i+1, j, grid);
        area += dfs(i, j-1, grid);
        area += dfs(i, j+1, grid);
        return area;
    }
}
