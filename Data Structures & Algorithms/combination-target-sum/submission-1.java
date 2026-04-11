class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), target, result);
        return result;
    }

    void backtrack(int[] nums, int index, List<Integer> temp, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        if (index >= nums.length) {
            return;
        }
        // unique combinations
        // select num[index]
        temp.add(nums[index]);
        backtrack(nums, index, temp, target - nums[index], result);

        temp.remove(temp.size() - 1);
        backtrack(nums, index + 1, temp, target, result);        
    }
}
