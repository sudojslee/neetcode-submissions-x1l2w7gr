class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    void dfs(String s, int start, List<String> temp, List<List<String>> result) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        } 


        for (int j = start; j < s.length(); j++) {
            if (isPalindrome(s, start, j)) {
                String pal = s.substring(start, j + 1);
                temp.add(pal);
                dfs(s, j + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
