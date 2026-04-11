class Solution {
    public int countSubstrings(String s) {
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
    
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return count;
            }
            left--;
            right++;

            count++;
        }

        return count;

    }
}
