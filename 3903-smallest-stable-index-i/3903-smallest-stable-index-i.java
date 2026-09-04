class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] maxValue = new int[nums.length];
        int[] minValue = new int[nums.length];

        maxValue[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            maxValue[i] = Math.max(maxValue[i - 1], nums[i]);
        }

        minValue[nums.length - 1] = nums[nums.length - 1];
        for(int i=nums.length - 2; i>= 0; i--){
            minValue[i] = Math.min(minValue[i+1], nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            if((maxValue[i] - minValue[i]) <= k){
                return i;
            }
        }
        return -1;
    }
}