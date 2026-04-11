class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] arr = new char[26];
        
        for (int i = 0; i < s.length(); i++){ 
            char c = s.charAt(i);
            arr[c - 'a']++;
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            arr[c - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
        

    }
}
