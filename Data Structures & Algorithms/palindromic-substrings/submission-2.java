class Solution {
    Integer[][] cache;
    public int countSubstrings(String s) {
        cache = new Integer[s.length()][s.length()];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd palindrome
            int l = i;
            int r = i;
            count += countPalindrome(s, l, r);
        
            l = i;
            r = i + 1;
            count += countPalindrome(s, l, r);
        }


        return count;
    }

    int countPalindrome(String s, int left, int right) {
        if (left < 0 || right >= s.length()) {
            return 0;
        }
        int l = left;
        int r = right;
        if (cache[l][r] != null) {
            return cache[l][r];
        }
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return count;
            }
            left--;
            right++;

            count++;
        }
        cache[l][r] = count;
        return count;

    }
}
