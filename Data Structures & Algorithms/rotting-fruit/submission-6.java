class Solution {
    public int orangesRotting(int[][] grid) {
        int total = 0;
        int rotten = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    // rotten, add to queue
                    total++;
                    rotten++;
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    // fresh fruit
                    total++;
                }
            }
        }

        if (total == rotten) {
            return 0;
        }

        int minutes= 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] arr = queue.poll();
                int i = arr[0];
                int j = arr[1];

                if (i-1 >= 0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    rotten++;
                    queue.add(new int[]{i-1, j});
                }

                if (j-1 >= 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    rotten++;
                    queue.add(new int[]{i, j-1});
                }

                if (i+1 < grid.length && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    rotten++;
                    queue.add(new int[]{i+1, j});
                }

                if (j+1 < grid[0].length && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    rotten++;
                    queue.add(new int[]{i, j+1});
                }
            }

            minutes++;
        }

        if (total == rotten) {
            return minutes-1;
        }

        return -1;
    }
}
