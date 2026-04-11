class Solution {

   
    public int numDecodings(String s) {

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(s, 0, dp);
    }

    int dfs(String s, int index, Map<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        // if (index == s.length()) {
        //     set.add(temp);
        //     return;
        // }

        // if (index > s.length()) {
        //     return;
        // }

        // 1 digit
        int res = 0;
        int numIndex = s.charAt(index) - '0';
        res += dfs(s, index + 1, dp);

        // 2 digits
        if (index + 1 < s.length()) {
            if (numIndex == 1 || (numIndex == 2 && (s.charAt(index + 1) - '0') <= 6)) {
                int secondDigit = Integer.valueOf(s.substring(index, index + 2));
        
                res += dfs(s, index + 2, dp);
            }
        }

        dp.put(index, res);
        return res;
    }
}
