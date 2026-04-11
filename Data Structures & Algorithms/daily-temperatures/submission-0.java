class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] - temperatures[i] > 0) {
                    result[i] = j-i;
                    break;                    
                }
            }

        }

        return result;
        
    }
}

// [30,38,30,36,35,40,28]

// 36,3
// 30,2
// 38,1
// 30,0
//
