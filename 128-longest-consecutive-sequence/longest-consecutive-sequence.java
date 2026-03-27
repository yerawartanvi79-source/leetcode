import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> sets = new HashSet<>();

        // Step 1: add all elements to set
        for (int num : nums) {
            sets.add(num);
        }

        int longest = 0;

        // Step 2: iterate through set
        for (int num : sets) {

            // check if it's the start of a sequence
            if (!sets.contains(num - 1)) {

                int current = num;
                int count = 1;

                // expand the sequence
                while (sets.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}