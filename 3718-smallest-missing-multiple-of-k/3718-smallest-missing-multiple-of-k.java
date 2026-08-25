class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hSet = new HashSet<>();
        for(int ele: nums){
            hSet.add(ele);
        }

        int counter = 1;
        while(true){
            if(hSet.contains(k * counter)){
                counter++;
            }
            else{
                return k * counter;
            }
        }
    }
}