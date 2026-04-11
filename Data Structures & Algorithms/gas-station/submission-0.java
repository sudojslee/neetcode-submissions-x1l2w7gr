class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for (int i = 0; i < gas.length; i++) {
            if (canTravel(gas, cost, i)) {
                return i;
            }
        }

        return -1;
    }

    boolean canTravel(int[] gas, int[] cost, int startIndex) {
        int gasAtStart = gas[startIndex];
        if (gasAtStart < cost[startIndex]) {
            return false;
        }
        int gass = 0;
        for (int i = startIndex; i < startIndex + gas.length; i++) {
            int index = i % gas.length;
            gass += gas[index];
            gass -= cost[index];
            if (gass < 0) {
                return false;
            }
                
        }
        return true;
    }
}
