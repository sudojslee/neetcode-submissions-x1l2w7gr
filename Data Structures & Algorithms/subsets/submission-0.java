class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> temp = new HashSet<>();
        backtrack(nums, 0, temp, result);
        
        return result;
    }

    void backtrack(int[] nums, int i, Set<Integer> temp, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // include ith element
        temp.add(nums[i]);
        backtrack(nums, i + 1, temp, result);

        // not include ith element
        temp.remove(nums[i]);
        backtrack(nums, i + 1, temp, result);
    }
}
