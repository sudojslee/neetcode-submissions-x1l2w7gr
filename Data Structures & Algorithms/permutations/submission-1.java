class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new HashSet<>(), result);
        return result;

    
    }

    void dfs(int[] nums, List<Integer> temp, Set<Integer> set, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, temp, set, result);

            temp.remove(temp.size() - 1);
            set.remove(nums[i]);
            // dfs(nums, i + 1, temp, set, result);
        }
    }
}
