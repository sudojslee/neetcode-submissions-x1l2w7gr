class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1,p2) -> p1[0]*p1[0] + p1[1]*p1[1] -  p2[0]*p2[0] - p2[1]*p2[1]);
        for (int[] point : points) {
            queue.add(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = queue.poll();
            result[i] = point;
        }

        return result;
    }
}
