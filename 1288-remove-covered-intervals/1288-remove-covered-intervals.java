class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            int firstColCompare = Integer.compare(a[0],b[0]);
            if(firstColCompare != 0){
                return firstColCompare;
            }
            return Integer.compare(b[1], a[1]);
        });

        int intervalsLen = intervals.length;

        int left = 0;
        int right = 1;
        int counter = 0;

        while((left < intervals.length) && (right < intervals.length)){
            while((right < intervals.length) && (intervals[right][1] <= intervals[left][1])){
                right++;
                counter++;
            }
            if(right < intervals.length){
                left = right;
                right = left + 1;
            }
        }

        return intervalsLen - counter;
    }
}