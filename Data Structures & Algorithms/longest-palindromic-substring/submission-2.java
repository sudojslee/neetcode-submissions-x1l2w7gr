class Solution {
    public String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {

            String sub = longestStartingFrom(s, i, i);

            if (sub.length() > longest.length()) {
                longest = sub;
            }
            
            sub = longestStartingFrom(s, i, i + 1);
            if (sub.length() > longest.length()) {
                longest = sub;
            }
        }

        return longest;
    }

    String longestStartingFrom(String s, int left, int right) {
        String longest = "";
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (longest.length() < right - left + 1) {
                    longest = s.substring(left, right + 1);
                }
                left--;
                right++;
            } else {
                break;
            }
            
        }

        return longest;
    }
}
