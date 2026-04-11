class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int longest = 1;
        Set<Character> set = new HashSet<>();
        int i = 0;

        
        for (int j = 0; j < s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            int currentLength = j - i + 1;
            longest = Math.max(currentLength, longest);
        }


        
        // while (i < j) {
        //     char cj = s.charAt(j);
            
        //     if (!set.contains(cj)) {
        //         set.add(cj);
        //         int currentLength = j - i + 1;
        //         longest = Math.max(currentLength, longest);
        //         j++;
        //         continue;
        //     }

        //     // move i right 
        //     while (set.contains(cj) && i < j) {
        //         set.remove(s.charAt(i));
        //         i++;
        //     }
            

        // }
        // Map<Character, Integer> freqMap = new HashMap<>();
        // int longest = 1;
    
        // int i = 0;
        // freqMap.put(s.charAt(i), 1);

        // int j = 1;
        // while (i < j) {
        //     char ci = s.charAt(i);
        //     char cj = s.charAt(j);

        //     freqMap.put(cj, freqMap.getOrDefault(cj, 0) + 1);

        //     if (freqMap.get(cj) == 1) {
        //         int currentLength = j - i + 1;
        //         longest = Math.max(currentLength, longest);
        //         j++;
        //     } else {
        //         // move i right until it matches
        //         while (freqMap.get(s.charAt(j)) != 1 && i < j) {
        //             freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) - 1);
        //             i++;
        //         }
        //     }
        
        // }

        return longest;
    }
}
