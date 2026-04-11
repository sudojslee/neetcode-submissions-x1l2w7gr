class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false; 
        }
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        
        int left = 0;
        int right = s1.length() - 1;

        while (right < s2.length()) {
            System.out.println(Arrays.toString(freq));
            if (isAllZeros(freq)) {
                return true;
            }

            freq[s2.charAt(left) - 'a']++;

            right++;
            if (right < s2.length()) {
                freq[s2.charAt(right) - 'a']--;
            }
            
            left++;
        }

        

        return false;
    }

    boolean isAllZeros(int[] freq) {
        for (int num : freq) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
