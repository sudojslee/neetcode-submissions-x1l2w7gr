class Solution {

    Map<Integer, String> map = new HashMap<>() {{ 
        put(1, "A");
        put(2, "B");
        put(3, "C");
        put(4, "D");
        put(5, "E");
        put(6, "F");
        put(7, "G");
        put(8, "H");
        put(9, "I");

        put(10, "J");
        put(11, "K");
        put(12, "L");  
        put(13, "M");  
        put(14, "N");  
        put(15, "O");  
        put(16, "P");  
        put(17, "Q");  
        put(18, "R");  
        put(19, "S");  
        put(20, "T");  
        put(21, "U");  
        // T U 
        put(22, "V");
        put(23, "W");     
        put(24, "X");     
        put(25, "Y");     
        put(26, "Z");     
    }};

    
    public int numDecodings(String s) {
        

        Set<String> set = new HashSet<>();
        dfs(s, 0, "", set);
        return set.size();
    }

    void dfs(String s, int index, String temp, Set<String> set) {
        if (index == s.length()) {
            set.add(temp);
            return;
        }

        if (index > s.length()) {
            return;
        }

        // 1 digit
        int numIndex = s.charAt(index) - '0';
        if (map.containsKey(numIndex)) {
            dfs(s, index + 1, temp + map.get(numIndex), set);
        }

        // 2 digits
        if (index + 1 >= s.length()) {
            return;
        }
        if (numIndex == 1 || (numIndex == 2 && (s.charAt(index + 1) - '0') <= 6)) {
            int secondDigit = Integer.valueOf(s.substring(index, index + 2));
            if (map.containsKey(secondDigit)) {
                dfs(s, index + 2, temp + map.get(secondDigit), set);
            }
        }
        
    }
}
