class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), target, result);

        return result;
    }

    void dfs(int[] nums, int i, List<Integer> temp, int target, List<List<Integer>> result) {
        int sum = 0;
        for (Integer in : temp) {
            sum += in;
        }
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target) {
            return;
        }
        if (i >= nums.length) {
            return;
        }

        // choose ith element
        temp.add(nums[i]);
        dfs(nums, i, temp, target, result);

        // do not choose ith element -> go to i+1
        temp.remove(temp.size() - 1);
        dfs(nums, i+1, temp, target, result);

    }
}
