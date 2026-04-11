class Solution {
    public void islandsAndTreasure(int[][] grid) {

        // bfs
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    // treasure chest -> traverse from here; 
                    queue.add(new int[]{i, j});
                }
            }
        }

        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] arr = queue.poll();
                int i = arr[0];
                int j = arr[1];
                
                int currentDistance = grid[i][j];

                currentDistance++;

                if (i - 1 >=0 && grid[i-1][j] == 2147483647) {
                    grid[i-1][j] = Math.min(currentDistance, grid[i-1][j]);
                    queue.add(new int[]{i-1 , j});
                }

                if (i + 1 < grid.length && grid[i + 1][j] == 2147483647) {
                    grid[i + 1][j] = Math.min(currentDistance, grid[i+1][j]);
                    queue.add(new int[]{i + 1, j});
                }

                if (j -1 >= 0 && grid[i][j-1] == 2147483647) {
                    grid[i][j-1] = Math.min(currentDistance, grid[i][j-1]);
                    queue.add(new int[]{i, j-1});
                }

                if (j + 1 < grid[0].length && grid[i][j+1] == 2147483647) {
                    grid[i][j + 1] = Math.min(currentDistance, grid[i][j+1]);
                    queue.add(new int[]{i, j+1});
                }

            }
        }
    }
}
