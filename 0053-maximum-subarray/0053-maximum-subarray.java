class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = -100000;
        int curSum = 0;

        for(int ele: nums){
            curSum += ele;

            maxSum = Math.max(curSum, maxSum);
            if(curSum < 0){
                curSum = 0;
            }
            
        }

        return maxSum;
    }
}