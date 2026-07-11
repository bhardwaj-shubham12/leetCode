class Solution {
    public int jump(int[] nums) {
        int numsLen = nums.length;
        int[] dp = new int[numsLen];
        for(int i=0;i<numsLen;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[numsLen - 1] = 0;
        int curIndex = -1;

        for(int i=numsLen-2;i>=0;i--){
            curIndex = i;
            for(int j=curIndex + 1; (j <= curIndex + nums[curIndex]) && (j < numsLen); j++){    
                dp[i] = (dp[j] == Integer.MAX_VALUE) ? dp[i]: Math.min(dp[i], 1  + dp[j]);
            }
        }

        return dp[0];
        
    }
}