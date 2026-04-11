class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();

        int i = 0;
        int j = s.length() -1;


        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(arr[i])) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(arr[j])) {
                j--;
            }

            if (arr[i] != arr[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
