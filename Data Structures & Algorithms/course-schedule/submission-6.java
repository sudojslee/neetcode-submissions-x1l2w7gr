class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];

            map.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int child : map.get(node)) {
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
