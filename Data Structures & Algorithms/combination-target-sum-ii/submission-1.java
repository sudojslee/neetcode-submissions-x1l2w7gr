class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // contains duplicates
        // at most once
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), target, result);
        return result;
    }

    void dfs(int[] candidates, int index, List<Integer> temp, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }

        if (candidates.length <= index) {
            return;
        }


        // if choose
        temp.add(candidates[index]);
        dfs(candidates, index + 1, temp, target - candidates[index], result);

        // if not choose -> skip that number
        temp.remove(temp.size() - 1);
        index++;
        while (index < candidates.length && candidates[index] == candidates[index - 1]) {
            index++;
        }
        dfs(candidates, index, temp, target, result);
    }
}
