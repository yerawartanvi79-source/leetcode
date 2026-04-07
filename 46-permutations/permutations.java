import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        
        // Base case
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip already used elements
            if (used[i]) continue;
            
            // Choose
            temp.add(nums[i]);
            used[i] = true;
            
            // Explore
            backtrack(nums, result, temp, used);
            
            // Backtrack (undo)
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}