class Solution {
    public boolean uniformArray(int[] nums1) {
        //find min value. All values should match its parity
        int[] ans = new int[nums1.length];
        int oddCount = 0;

        int minVal = nums1[0];
        
        for(int ele: nums1){
            minVal = Math.min(minVal, ele);
            oddCount += (ele % 2 == 0) ? 0: 1;
        }

        boolean isSmallestOdd = ((minVal % 2) != 0);

        //If all odd -> true
        //If all but one even -> true
        //If one even -> true
        if(isSmallestOdd) return true;

        //If one odd -> false
        //If all but one odd -> false (odd - even will be odd for one)
        //return true for all even
        if(oddCount == 0) return true;
        return false;


    }
}