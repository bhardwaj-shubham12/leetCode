class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> numberToSeqLen = new HashMap<>();
        int left = 0,right = 0;
        int sum = 0, res = 0;

        for(int ele: nums){
            if(numberToSeqLen.containsKey(ele)) continue;
            left = numberToSeqLen.getOrDefault(ele-1,0);
            right = numberToSeqLen.getOrDefault(ele+1,0);

            sum = left + right + 1;
            res = Math.max(sum, res);

            numberToSeqLen.put(ele - left, sum);
            numberToSeqLen.put(ele + right, sum);
            numberToSeqLen.put(ele, sum);
            
            //System.out.println((ele-left)+", "+ele+", "+(ele+right)+": "+sum);
        }

        return res;
    }
}