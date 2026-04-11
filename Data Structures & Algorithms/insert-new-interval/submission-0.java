class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 1. no overlap
        // 2. overlap with prev
        // 3. overlap with next
        // 4. overlap with both
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // overlap
        int minStart = newInterval[0];
        int maxEnd = newInterval[1];
        while (i < n && intervals[i][0] <= newInterval[1]) {
            minStart = Math.min(minStart, intervals[i][0]);
            maxEnd = Math.max(maxEnd, intervals[i][1]);
            i++;
        }
        result.add(new int[]{minStart, maxEnd});

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        int[][] res = new int[result.size()][2];
        for (int j = 0; j < result.size(); j++) {
            res[j] = result.get(j);
        }

        return res;

        
    }
}
