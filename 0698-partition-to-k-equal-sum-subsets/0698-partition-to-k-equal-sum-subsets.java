import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        // Base checks
        if (sum % k != 0 || k > nums.length) return false;
        int target = sum / k;
        
        // Sort ascending, then we will iterate backwards to simulate descending order
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > target) return false; 
        
        // Track the current sum of each of the k subsets
        int[] subsets = new int[k];
        
        // Start distributing elements from the largest (end of sorted array)
        return backtrack(nums, n - 1, subsets, target);
    }
    
    private boolean backtrack(int[] nums, int index, int[] subsets, int target) {
        // All elements successfully placed
        if (index < 0) return true;
        
        int currentNum = nums[index];
        
        for (int i = 0; i < subsets.length; i++) {
            // Check if current element fits in the subset
            if (subsets[i] + currentNum <= target) {
                subsets[i] += currentNum;
                
                // Move to the next smaller element
                if (backtrack(nums, index - 1, subsets, target)) {
                    return true;
                }
                
                // Backtrack
                subsets[i] -= currentNum;
            }
            
            // Optimization: If the subset is empty after backtracking, 
            // breaking here avoids putting the current element into other empty subsets (which creates identical states).
            if (subsets[i] == 0) {
                break;
            }
        }
        
        return false;
    }
}