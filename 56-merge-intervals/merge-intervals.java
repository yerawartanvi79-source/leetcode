import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Start with first interval
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // Step 3: Check overlap
            if (next[0] <= current[1]) {
                // Merge intervals
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → store current and move forward
                result.add(current);
                current = next;
            }
        }

        // Add the last interval
        result.add(current);

        // Convert list to array
        return result.toArray(new int[result.size()][]);
    }
}