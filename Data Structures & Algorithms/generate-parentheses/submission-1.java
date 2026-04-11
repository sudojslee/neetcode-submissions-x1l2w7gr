class Solution {
    public List<String> generateParenthesis(int n) {
        // open parentheses, closed parenthese
        List<String> result = new ArrayList<>();
        generateParenthesis(0, 0, n, "", result);
        return result;
    }
    
    void generateParenthesis(int open, int closed, int n, String temp, List<String> result) {
        if (open == closed && open == n) {
            result.add(temp);
            return;
        }
        if (open > n || closed > n) {
            return;
        }

        if (open < n) {
            // can add open
            generateParenthesis(open + 1, closed, n, temp + "(", result);
        }

        if (open > closed && closed < n) {
            generateParenthesis(open, closed + 1, n, temp + ")", result);
        }
    }

}
