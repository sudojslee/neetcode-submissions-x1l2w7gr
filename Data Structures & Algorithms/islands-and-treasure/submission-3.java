class Solution {
    int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        LinkedList<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                    // traverse(grid, i, j, 0, visited);
                }
            }
        }

        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                int a = curr[0];
                int b = curr[1];

                // if (grid[a][b] == distance) {
                //     continue;
                // }
                if (visited[a][b]) {
                    continue;
                }

                grid[a][b] = distance;
                visited[a][b] = true;
                // System.out.println("i:" + a + ", j:" + b + ":" + distance);

                if (a-1 >=0 && grid[a-1][b] == INF) {
                    q.add(new int[]{a-1, b});
                }
                if (a + 1 < grid.length && grid[a+1][b] == INF) {
                    q.add(new int[]{a+1, b});
                }
                
                if (b-1 >=0 && grid[a][b-1] == INF) {
                    q.add(new int[]{a, b-1});
                }
                if (b + 1 < grid[0].length && grid[a][b+1] == INF) {
                    q.add(new int[]{a, b+1});
                }

            }   
            distance++;   
        }  
    }

    // bfs
    void traverse(int[][] grid, int i, int j, int distance, boolean[][] visited) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == -1) {
            return;
        }
        if (visited[i][j]) {
            return;
        }

        grid[i][j] = Math.min(distance, grid[i][j]);
        visited[i][j] = true;

        distance++;
        traverse(grid, i+1, j, distance, visited);
        traverse(grid, i-1, j, distance, visited);
        traverse(grid, i, j-1, distance, visited);
        traverse(grid, i, j+1, distance, visited);
    }

    
}
