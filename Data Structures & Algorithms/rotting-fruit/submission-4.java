class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                   queue.add(new int[]{i,j}); 
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            int k = queue.size(); 
            for (int a = 0; a < k; a++) {
                int[] arr = queue.poll();
                int i = arr[0];
                int j = arr[1];
                // mark as rotten
                
                if (i-1 >= 0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    freshCount--;
                    queue.add(new int[]{i-1, j});
                }
                if (i+1 < grid.length && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    freshCount--;
                    queue.add(new int[]{i+1, j});
                }
                if (j-1 >= 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    freshCount--;
                    queue.add(new int[]{i, j-1});
                }
                if (j + 1 < grid[0].length && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    freshCount--;
                    queue.add(new int[]{i, j+1});
                }
            }
            
            minutes++;
        }

        if (freshCount > 0) {
            return -1;
        }

        return Math.max(0, minutes - 1);
    }
}
