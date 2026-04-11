class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            // b -> a
            graph.get(b).add(a);
        }

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=done

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(graph, i, state)) {
                return false;
            }
        }

        return true;
    }

    // if hasCycle -> return false

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int i, int[] state) {
        state[i] = 1;

        List<Integer> neighbors = graph.get(i);
        for (int neigh : neighbors) {
            if (state[neigh] == 1) {
                return true;
            }
            if (state[neigh] == 0) {
                if (hasCycle(graph, neigh, state)) {
                    return true;
                }
            }
        }
        state[i] = 2;

        return false;
    }
}
