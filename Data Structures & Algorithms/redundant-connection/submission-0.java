class Solution {
    //  connected non-cyclical graph
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i + 1, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            boolean[] visited = new boolean[n + 1];

            if (hasCycle(graph, edge[0], -1, visited)) {
                return edge;
            }
        }

        return new int[]{};
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int node, int parent, boolean[] visited) {
        if (visited[node]) {
            return true;
        }

        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (hasCycle(graph, neighbor, node, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isConnectedNonCyclicGraph(Map<Integer, Set<Integer>> graph, int n) {
        // is connected 
        for (int i = 0; i < n; i++) {
            if (graph.get(i + 1).isEmpty()) {
                return false;
            }
        }

        // has cycle
        if (hasCycle(graph)) {
            return false;
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, Set<Integer>> graph) {
        // Set<Integer> visited = new HashSet<>();

        for (int key : graph.keySet()) {
            Set<Integer> visited = new HashSet<>();
            visited.add(key);
            Set<Integer> neighbors = graph.get(key);
            for (int neighbor : neighbors) {
                if (visited.contains(neighbor)) {
                    return true;
                }
                if (hasCycle(graph, neighbor, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean hasCycle(Map<Integer, Set<Integer>> graph, int i, Set<Integer> visited) {
        if (visited.contains(i)) {
            return false;
        }

        visited.add(i);

        Set<Integer> neighbors = graph.get(i);
        for (int neighbor : neighbors) {
            if (visited.contains(neighbor)) {
                return true;
            }
            if (hasCycle(graph, neighbor, visited)) {
                return true;
            }
        }
        
        return false;
    }
}
