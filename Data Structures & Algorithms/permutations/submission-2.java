class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums, Set<Integer> set, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            temp.add(nums[i]);

            backtrack(nums, set, temp, result);

            set.remove(nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
