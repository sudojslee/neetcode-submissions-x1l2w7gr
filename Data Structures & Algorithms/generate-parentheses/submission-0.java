class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, "", result);
        return result;
    }

    void dfs(int n, int open, int closed, String curr, List<String> result) {
        if (open == n && closed == n) {
            result.add(curr);
            return;
        }
        if (open > n || closed > n) {
            return;
        }

        if (open < n) {
            dfs(n, open + 1, closed, curr + "(", result);
        }

        if (open > closed) {
            dfs(n, open, closed + 1, curr + ")", result);
        }
    }
}
