class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = position[i];
            sorted[i][1] = speed[i];
        }
        Arrays.sort(sorted, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();
        for (int[] pair : sorted) {
            stack.push((double) (target - pair[0]) / pair[1]);

            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        
        return stack.size();
        // sort this stack
    }
}
