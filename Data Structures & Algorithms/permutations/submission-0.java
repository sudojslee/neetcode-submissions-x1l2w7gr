class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     set.add(num);
        // }

        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, new ArrayList<>(), new boolean[nums.length], result);
    
        return result;
    }

    void dfs(int[] nums, List<Integer> temp, boolean[] pick, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!pick[i]) {
                temp.add(num);
                pick[i] = true;
                dfs(nums, temp, pick, result);
                temp.remove(temp.size() - 1);
                pick[i] = false;
            }
        
        }

    }
}
