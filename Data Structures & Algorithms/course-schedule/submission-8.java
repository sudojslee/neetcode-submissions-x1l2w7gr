class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            graph.get(b).add(a);
            indegree[a]++;
            // a, b : b -> a
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            int i = queue.poll();

            for (int child : graph.get(i)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.add(child);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
