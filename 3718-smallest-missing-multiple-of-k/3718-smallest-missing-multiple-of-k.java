class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int counter = 1;
        int num = k;
        
        for(int ele: nums){
            if(ele == num){
                num = (k * (++counter));
            }
        }

        return num;
    }
}