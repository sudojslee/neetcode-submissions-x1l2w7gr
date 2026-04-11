class Solution {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            if (count[num-1] != 0) {
                return num;
            }
            count[num-1]++;
        }

        return -1;
    }
}
