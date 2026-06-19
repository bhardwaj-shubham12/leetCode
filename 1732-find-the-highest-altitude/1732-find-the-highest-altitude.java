class Solution {
    public int largestAltitude(int[] gain) {
        int curVal = 0;
        int maxVal = 0;

        for(int ele: gain){
            curVal += ele;
            maxVal = (curVal > maxVal) ? curVal : maxVal;
        }


        return maxVal;

    }
}