class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        // sorted string, List of original string)
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(str);
                map.put(sorted, ls);
            }
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
