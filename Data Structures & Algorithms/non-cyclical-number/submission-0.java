class Solution {

    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        
        int result = 0;
        String s = String.valueOf(n);
        // System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            // System.out.println(digit);
            result += digit * digit;
        }

        if (result == 1) {
            return true;
        }



        if (set.contains(result)) {
            return false;
        }
        set.add(result);

        return isHappy(result);
    }
}
