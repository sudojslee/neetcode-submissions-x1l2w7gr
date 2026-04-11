class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        // pacific
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, pac);
            dfs(heights, i, heights[0].length - 1, atl);
        }

        for (int j = 0; j < heights[0].length; j++) {
            dfs(heights, 0, j, pac);
            dfs(heights, heights.length - 1, j, atl);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    void dfs(int[][] heights, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= heights.length) {
            return;
        }
        if (j < 0 || j >= heights[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        int current = heights[i][j];

        if (i + 1 < heights.length && heights[i+1][j] >= current) {
            dfs(heights, i + 1, j, visited);
        }

        if (i-1 >= 0 && heights[i-1][j] >= current) {
            dfs(heights, i - 1, j, visited);
        }

        if (j-1 >= 0 && heights[i][j-1] >= current) {
            dfs(heights, i, j-1, visited);            
        }

        if (j + 1 < heights[0].length && heights[i][j+1] >= current) {
            dfs(heights, i, j+1, visited);
        }
        
    }
}
