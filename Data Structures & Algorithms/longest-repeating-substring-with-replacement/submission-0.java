class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> count = new HashMap<>();
            int maxf = 0;

            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(maxf, count.get(s.charAt(j)));

                int windowSize = j - i + 1;
                if (windowSize - maxf <= k) {
                    // valid
                    longest = Math.max(longest, windowSize);
                }
            }
        }
        return longest;
    }
}
