class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        int row = heights.length;
        int col = heights[0].length;

        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, -1, pacific);
            dfs(heights, i, col - 1, -1, atlantic);
        }
        for (int j = 0; j < col; j++) {
            dfs(heights, 0, j, -1, pacific);
            dfs(heights, row - 1, j, -1, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        
        for (List<Integer> pac : pacific) {
            if (atlantic.contains(pac)) {
                result.add(pac);
            }
        }

        return result;
    }

    void dfs(int[][] heights, int i, int j, int prev, Set<List<Integer>> set) {
        if (i < 0 || i >= heights.length) {
            return;
        }
        if (j < 0 || j >= heights[0].length) {
            return;
        }

        int current = heights[i][j];
        if (current < prev) {
            return;
        }

        List<Integer> key = List.of(i, j);
        if (set.contains(key)) return;
        
        set.add(List.of(i, j));
        dfs(heights, i - 1, j, current, set);
        dfs(heights, i + 1, j, current, set);
        dfs(heights, i, j - 1, current, set);
        dfs(heights, i, j + 1, current, set);
    }
}
