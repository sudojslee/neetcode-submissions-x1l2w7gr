class Solution {
           public boolean validTree(int n, int[][] edges) {
            if (edges.length != n - 1) {
                return false;
            }
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean[] visited = new boolean[n];
            dfs(graph, visited, 0);

            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }
            
            return true;
        }

        private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int i) {
            if (visited[i]) {
                return;
            }

            visited[i] = true;
            List<Integer> neighbors = graph.get(i);
            for (int neighbor : neighbors) {
                dfs(graph, visited, neighbor);
            }
        }
}
