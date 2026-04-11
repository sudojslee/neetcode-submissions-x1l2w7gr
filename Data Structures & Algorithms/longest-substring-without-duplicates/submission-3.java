class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (freq.get(c) == null || freq.get(c) == 0) {
                freq.put(c, 1);
                longest = Math.max(longest, r - l + 1);
                continue;
            } else {
                freq.put(c, freq.get(c) + 1);
                while (freq.get(c) != 1) {
                    char leftC = s.charAt(l);
                    freq.put(leftC, freq.get(leftC) - 1);
                    l++;
                }
            }
        }
        return longest;
    }
}
