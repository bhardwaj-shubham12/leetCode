class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();

        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        int curSum = 0;
        int counter = 0;

        for(int i=0;i<nums.length;i++){
            
            curSum += nums[i];
            
            if(sumMap.containsKey(curSum - k)){
                counter += sumMap.get(curSum - k).size();
            }
            
            if(!sumMap.containsKey(curSum)){
                sumMap.put(curSum, new ArrayList<>());
            }
            
            sumMap.get(curSum).add(i);
        }

        return counter;
    }
}