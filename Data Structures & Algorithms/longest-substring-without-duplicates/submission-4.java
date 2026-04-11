class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int longest = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (freq.containsKey(c) && freq.get(c) == 1) {
                while (freq.get(c) != 0) {
                    freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                    i++;
                }
            }
            freq.put(c, 1);
            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }
}
