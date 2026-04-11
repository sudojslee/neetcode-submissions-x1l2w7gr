class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (index > nums.length) {
            return;
        }

        // choose nums[i]
        temp.add(nums[index]);
        dfs(nums, index + 1, temp, result);

        temp.remove(temp.size() - 1);
        // do not choose nums[i] -> loop until unique
        index++;
        while (index < nums.length && nums[index] == nums[index-1]) {
            index++;
        }
        dfs(nums, index, temp, result);
        // do not choose nums[i] -> loop untiul unique
    }
}
