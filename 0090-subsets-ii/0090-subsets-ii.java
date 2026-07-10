class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> listSet = new HashSet<>();
        int numsLen = nums.length;
        int numSet = (int)Math.pow(2,numsLen);
        //System.out.println(numSet);

        for(int i=0;i<numSet;i++){
            List<Integer> temp = new ArrayList<>();
            //System.out.println("Set:"+i);
            for(int j=0;j<numsLen;j++){
                if((i & (1 << j)) > 0){
                    //System.out.println("Adding " + j + " for set: "+i);
                    temp.add(nums[j]);
                }
            }
            if(!listSet.contains(temp)){
                ans.add(temp);
                listSet.add(temp);
            }

        }

        return ans;
    }
}