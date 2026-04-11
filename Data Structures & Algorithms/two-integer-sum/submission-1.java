class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = target - num;
            if (map.containsKey(temp)) {
                int a = map.get(temp);
                return new int[]{a, i};
            } else {
                map.put(num, i);
            }
        }
        return new int[]{};
    }
}
