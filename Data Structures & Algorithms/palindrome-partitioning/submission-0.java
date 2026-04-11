class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();

        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    void dfs(String s, int i, List<String> part, List<List<String>> result) {
        
        if (i >= s.length()) {  
            result.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                part.add(s.substring(i, j + 1));
                dfs(s, j + 1, part, result);
                part.remove(part.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
