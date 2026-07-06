class Solution {
    public int maxProduct(int[] nums) {
        int maxP = -11;
        int minP = 11;

        int res = -11;

        maxP = nums[0];
        minP = nums[0];
        res =  nums[0];


        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxP * curr, minP * curr));
            int tempMin = Math.min(curr, Math.min(minP * curr, maxP * curr));

            maxP = tempMax;
            minP = tempMin;
            res = Math.max(maxP, res);
        }

        return res;
    }
}