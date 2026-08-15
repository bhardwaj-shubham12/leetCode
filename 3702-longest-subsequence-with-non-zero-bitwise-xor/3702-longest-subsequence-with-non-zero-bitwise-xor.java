class Solution {
    public int longestSubsequence(int[] nums) {
        int numsLen = nums.length;
        int res = nums[0];
        boolean numNonZero = false;
        numNonZero = (nums[0] == 0) ? numNonZero : true;

        for(int i=1;i<numsLen;i++){
            res = res ^ nums[i];
            numNonZero = (nums[i] == 0) ? numNonZero: true;
        }

        if(numNonZero == false){
            return 0;
        }

        if(res >= 1){
            return numsLen;
        }
        return numsLen - 1;
    }
}