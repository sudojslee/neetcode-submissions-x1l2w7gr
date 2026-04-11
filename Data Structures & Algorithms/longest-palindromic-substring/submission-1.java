class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            // odd palindrome
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int length = r - l + 1;
                if (length > longest.length()) {
                    longest = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            // even palindrome
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int length = r - l + 1;
                if (length > longest.length()) {
                    longest = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }

        return longest;
    }
}
