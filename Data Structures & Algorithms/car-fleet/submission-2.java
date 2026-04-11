class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        // time * speed = position

        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        // time = (target - position) / speed


        Stack<Double> stack = new Stack<>();

        for (int[] car: cars) {
            stack.push((double)(target - car[0]) / car[1]);

            if (stack.size() >= 2) {
                if (stack.peek() <= stack.get(stack.size() - 2)) {
                    stack.pop();
                }
            }
        }

        

        return stack.size();

        
        
        
    }
}
