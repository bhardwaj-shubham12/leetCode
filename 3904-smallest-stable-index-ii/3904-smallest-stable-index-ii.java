class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] maxVal = new int[nums.length];
        int[] minVal = new int[nums.length];
        
        maxVal[0] = nums[0];
        minVal[nums.length - 1] = nums[nums.length - 1];

        for(int i=1;i<nums.length;i++){
            maxVal[i] = Math.max(maxVal[i-1], nums[i]);
        }

        for(int i=nums.length-2;i>=0;i--){
            minVal[i] = Math.min(minVal[i+1], nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            if((maxVal[i] - minVal[i]) <= k) return i;
        }

        return -1;
    }

}