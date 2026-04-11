class Solution {
    char[][] map = {
        {},
        {},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        dfs(digits, 0, "", result);
        return result;
    }

    void dfs(String digits, int index, String temp, List<String> result) {
        if (digits.isEmpty()) {
            return;
        }
        if (temp.length() == digits.length()) {
            result.add(temp);
            return;
        }

        int i = digits.charAt(index) - '0';
        for (char c : map[i]) {
            dfs(digits, index + 1, temp + c, result);
        }
    }
    
}
