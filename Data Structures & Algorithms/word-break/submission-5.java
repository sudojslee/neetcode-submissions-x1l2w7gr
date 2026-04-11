class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, 0, wordDict, memo);
    }

    boolean dfs(String s, int index, List<String> wordDict, Boolean[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }

        boolean result = false;
        for (String word : wordDict) {
            if (index + word.length() > s.length()) {
                continue;
            }
            String substring = s.substring(index, index + word.length());
            if (word.equals(substring)) {
                result = result || dfs(s, index + word.length(), wordDict, memo);
            }
        }

        memo[index] = result;
        return result;
    }

        // int i = 0;
        // int j = 0; 

        // while (j <= s.length()) {
        //     String substring = s.substring(i, j);
        //     System.out.println(substring);
        //     if (set.contains(substring)) {
        //         i = j;
        //         System.out.println("i: " + i);
        //         System.out.println("j: " + j);
        //     } else {
        //         j++;
        //     }
        // }
        // if (i == s.length()) {
        //     return true;
        // } 
        // return false;

}
