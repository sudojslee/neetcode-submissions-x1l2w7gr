class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        dfs(0, graph, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    
    }

    private void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            dfs(neighbor, graph, visited);
        }
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int n) {
        // i = root node
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            List<Integer> neighbors = graph.get(i);
            for (int neighbor : neighbors) {
                if (visited[neighbor]) {
                    return true;
                }
                if (dfs(graph, neighbor, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int i, int parent, boolean[] visited) {
        if (visited[i]) {
            return true;
        }

        visited[i] = true;
        List<Integer> neighbors = graph.get(i);
        for (int neighbor : neighbors) {
            if (neighbor == parent) {
                continue;
            }
            if (dfs(graph, neighbor, i, visited)) {
                return true;
            }
        }

        return false;
    }
}
