class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, 0, new ArrayList<>(), result);
        
        return result;
    }

    void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList(temp));
            return;
        }

        // pick
        temp.add(nums[index]);
        dfs(nums, index + 1, temp, result);

        // not pick
        temp.remove(temp.size() - 1);
        // if not pick, skip all duplicates
        index++;
        while (index < nums.length && nums[index] == nums[index-1]) {
            index++;
        }
        dfs(nums, index, temp, result);
    }
}
