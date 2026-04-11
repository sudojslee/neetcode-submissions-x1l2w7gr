class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd palindrome
            int l = i;
            int r = i;
            count += countPalindrome(s, l, r);

            // if (isPalindrome(s, l, r)) {
            //     System.out.println(s.substring(l, r + 1));
            //     count++;
            // }

            // even palindrome
        
            l = i;
            r = i + 1;
            count += countPalindrome(s, l, r);
            // if (isPalindrome(s, l, r)) {
            //     System.out.println(s.substring(l, r));
            //     count++;
            // }          
        }


        return count;
    }

    int countPalindrome(String s, int left, int right) {
        if (left < 0 || right >= s.length()) {
            return 0;
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
        return count;

    }

    boolean isPalindrome(String s, int left, int right) {
        if (left < 0 || right >= s.length()) {
            return false;
        }
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
