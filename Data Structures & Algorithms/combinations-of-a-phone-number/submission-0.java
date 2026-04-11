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
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        // permutations
        List<String> result = new ArrayList<>();
        dfs(digits, 0, "", result);
        return result;
    }

    void dfs(String digits, int index, String temp, List<String> result) {
        if (temp.length() == digits.length()) {
            result.add(temp);
            return;
        }

        char[] chars = map[digits.charAt(index) - '0'];
        // System.out.println(Arrays.toString(chars));
        for (char c : chars) {
            dfs(digits, index + 1, temp + c, result);
        }

    }
}
