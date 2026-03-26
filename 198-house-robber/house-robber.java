class Solution {
    public int rob(int[] nums) {
        
        int take = 0;   // rob current house
        int skip = 0;   // skip current house
        
        for (int i = 0; i < nums.length; i++) {
            int newTake = skip + nums[i]; // if we rob this
            int newSkip = Math.max(skip, take); // if we skip
            
            take = newTake;
            skip = newSkip;
        }
        
        return Math.max(take, skip);
    }
}