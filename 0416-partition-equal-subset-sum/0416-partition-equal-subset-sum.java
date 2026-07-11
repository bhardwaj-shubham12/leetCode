class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if((sum % 2) == 1) return false;
        int targetSum = sum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for(int ele: nums){
            for(int curSum = targetSum; curSum >= ele; curSum--){
                dp[curSum] = dp[curSum] | dp[curSum - ele];
                if(dp[targetSum]) return true;
            }
        }

        return dp[targetSum];
    }
}