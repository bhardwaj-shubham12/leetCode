class Solution {
    int dfsUtil(int[] piles, int[][] dp, int l, int r){
        if(l == r){
            return piles[l];
        }

        if(dp[l][r] != -1) return dp[l][r];

        dp[l][r] = Math.max(piles[l] - dfsUtil(piles,dp,l+1,r),
            piles[r] - dfsUtil(piles,dp,l,r-1)
        );

        return dp[l][r];
    }
    public boolean stoneGame(int[] piles) {
        int[][] diff = new int[piles.length][piles.length];
        for(int i=0;i<diff.length;i++){
            for(int j=0;j<diff.length;j++){
                diff[i][j] = -1;
            }
        }

        int res = dfsUtil(piles, diff, 0, piles.length - 1);
        if(res > 0) return true;
        return false;
    }
}