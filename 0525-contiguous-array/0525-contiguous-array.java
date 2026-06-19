class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> diffMap = new HashMap<>();

        int numOne = 0;
        int numZero = 0;
        int maxSize = 0;

        diffMap.put(0, -1);

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                numZero++;
            }
            else{
                numOne++;
            }
            if(diffMap.containsKey(numOne - numZero)){
                maxSize = Math.max(maxSize, i - diffMap.get(numOne - numZero));
            }
            else{
                diffMap.put((numOne - numZero), i);
            }
        }

        return maxSize;
    }
}