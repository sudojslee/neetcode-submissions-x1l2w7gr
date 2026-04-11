class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];

            // previous temperature
            while (!stack.isEmpty() && stack.peek()[1] < temp) {
                int[] prev = stack.pop();
                int index = prev[0];
                result[index] = i - index;
            }
            stack.add(new int[]{i, temp});

        }

        return result;
    }
}
