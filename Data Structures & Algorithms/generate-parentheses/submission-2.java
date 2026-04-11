class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();


        generate(0, 0, n, "", result);
        return result;
    }

    void generate(int open, int closed, int n, String temp, List<String> result) {
        if (open == closed && open == n) {
            result.add(temp);
            return;
        }
        if (open > n || closed > n) {
            return;
        }

        if (open < n) {
            generate(open + 1, closed, n, temp + "(", result);
        }

        if (open > closed) {
            generate(open, closed + 1, n, temp + ")", result);
        }
    

    }
}
