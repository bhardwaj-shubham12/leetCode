class Solution {
    public int jump(int[] nums) {
        int curFarthest = 0, curEnd = 0, jumps = 0;
        for(int i=0;i<nums.length - 1 ;i++){
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if(i == curEnd){
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}