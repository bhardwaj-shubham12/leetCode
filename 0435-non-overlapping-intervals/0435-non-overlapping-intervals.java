class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x,y) -> Integer.compare(x[1], y[1]));

        int prevEnd = intervals[0][1];
        int curIndex = 1;
        int res = 0;

        while(curIndex < intervals.length){
            if(prevEnd > intervals[curIndex][0]){
                res++;
            }
            else{
                prevEnd = intervals[curIndex][1];
            }
            curIndex++;
        }

        return res;
    }
}