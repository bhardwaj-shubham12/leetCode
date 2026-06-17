class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k];

        int sum = 0;
        int counter = 0;
        int rem = 0;
        freq[0] = 1;
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            
            rem = sum % k;
            if(rem < 0){
                rem = rem + k;
            }

            counter += freq[rem];
            freq[rem]++;
        }

        return counter;
    }
}