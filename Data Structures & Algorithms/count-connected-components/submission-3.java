class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int ai = edges[i][0];
            int bi = edges[i][1];
            if (!graph.containsKey(ai)) {
                graph.put(ai, new ArrayList<>());
            }
            if (!graph.containsKey(bi)) {
                graph.put(bi, new ArrayList<>());
            }

            graph.get(ai).add(bi);
            graph.get(bi).add(ai);
        }

        boolean[] visited = new boolean[n];

        int component = 0;
        for (int i = 0; i < n; i++) { 
            if (!visited[i]) {
                traverse(graph, i, visited);
                component++;
            }
        }
        return component;
        // 2. dfs and count unique trees
    }

    void traverse(Map<Integer, List<Integer>> graph, int index, boolean[] visited) {

        if (visited[index]) {
            return;
        }

        visited[index] = true;
        if (!graph.containsKey(index)) {
            return;
        }
        List<Integer> edges = graph.get(index); 

        for (int edge : edges) {
            traverse(graph, edge, visited);
        }
        
    }
}
