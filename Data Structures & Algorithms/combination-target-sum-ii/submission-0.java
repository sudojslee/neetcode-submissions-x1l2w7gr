class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, new ArrayList<>(), target, result);

        return result;
    }

    void dfs(int[] candidates, int i, List<Integer> temp, int target, List<List<Integer>> result) {
    
        int sum = sum(temp);
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target) {
            return;
        }
        if (i >= candidates.length) {
            return;
        }

        // select ith element
        temp.add(candidates[i]);
        dfs(candidates, i + 1, temp, target, result);

        // do not select ith element
        // iterate through the next non-duplicate element
        temp.remove(temp.size() - 1);
        i++;
        while (i < candidates.length && candidates[i] == candidates[i-1]) {
            i++;
        }
        dfs(candidates, i, temp, target, result);

    }

    int sum(List<Integer> temp) {
        int sum = 0;
        for (Integer i : temp) {
            sum += i;
        }
        return sum;
    }
}
