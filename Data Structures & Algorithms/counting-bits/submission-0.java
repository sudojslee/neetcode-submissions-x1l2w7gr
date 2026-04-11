class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            res[i] = count(i);
        }

        return res;
    }

    int count(int n) {
        int res = 0;
        
        while (n != 0) {
            res += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
        }

        return res;
    }
}
