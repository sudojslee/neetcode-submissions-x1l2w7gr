class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(i, j, grid);
                    numIslands++;
                }
                
            }
        }
        return numIslands;
    }

    void dfs(int i, int j, char[][] grid) { 
        if (i < 0 || i > grid.length - 1) {
            return;
        }
        if (j < 0 || j > grid[0].length - 1) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        // mark as visited
        grid[i][j] = '2';
        
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }
}
