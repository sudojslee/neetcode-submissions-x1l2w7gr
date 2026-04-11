class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, 0, memo);
    }

    boolean dfs(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
        if (k == s3.length()) {
            if (i == s1.length() && j == s2.length()) {
                memo[i][j] = true;
                return true;
            }
            
            memo[i][j] = false;
            return false;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (dfs(s1, s2, s3, i + 1, j, k + 1, memo)) {
                return true;
            }
        }


        // s2
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (dfs(s1, s2, s3, i, j + 1, k + 1, memo)) {
                return true;
            }
        }

        memo[i][j] = false;
        return false;     
    }
}
