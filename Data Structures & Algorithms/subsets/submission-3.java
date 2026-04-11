class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        if (nums.length == index) {
            result.add(new ArrayList<>(temp));
            return;
        }

        backtrack(nums, index + 1, temp, result);
        
        temp.add(nums[index]);
        backtrack(nums, index + 1, temp, result);
        temp.remove(temp.size() - 1);
    }

}
