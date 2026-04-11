class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int ni = nums[i];

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int nj = nums[j];
                int nk = nums[k];

                if (ni + nj + nk == 0) {
                    result.add(List.of(ni, nj, nk));
                    // remove duplicates
                    j++;
                    while (j < nums.length&&j-1 >= 0 && nums[j] == nums[j-1]) {
                        j++;
                    }
                    k--;
                    while (k>=0 && k+1 < nums.length && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if (ni + nj + nk > 0) {
                    k--;
                    
                } else {
                    j++;
            
                }
            }
        }



        return new ArrayList<>(result);
    }
}
