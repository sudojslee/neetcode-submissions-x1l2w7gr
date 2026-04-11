class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 0 -> numCourses - 1;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        // has cycle?
        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            if (hasCycle(graph, i, visited)) {
                return false;
            }
        }

        return true;
    }

    boolean hasCycle(Map<Integer, List<Integer>> graph, int i, boolean[] visited) {
        if (visited[i]) {
            return true;
        }
        visited[i] = true;
        List<Integer> neighbors = graph.get(i);
        for (int neighbor : neighbors) {
            if (hasCycle(graph, neighbor, visited)) {
                return true;
            }
        }
        visited[i] = false;
        return false;
    }
}
