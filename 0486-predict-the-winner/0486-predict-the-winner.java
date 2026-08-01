class Solution {
    int maxDiff(int[] nums, int l, int r, int[][] dp){
        if(l == r){
            return nums[l];
        }

        if(dp[l][r] != -1) return dp[l][r];

        dp[l][r] = Math.max(
            nums[l] - maxDiff(nums,l+1,r,dp),
            nums[r] - maxDiff(nums,l,r-1,dp)
        );

        return dp[l][r];
    }
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                dp[i][j] = -1;
            }
        }
        
        int res = maxDiff(nums,0,nums.length-1,dp);
        if(res < 0) return false;
        return true;
    }
}