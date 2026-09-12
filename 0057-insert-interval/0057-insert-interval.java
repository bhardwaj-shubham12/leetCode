class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] ans = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }

        List<int[]> intervalsRes = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int curIndex = 0;
        int numInterval = intervals.length;

        while((curIndex <numInterval) && (intervals[curIndex][1] < newInterval[0])){
            intervalsRes.add(intervals[curIndex++]);
        }

        while((curIndex <numInterval) && (intervals[curIndex][0] <= newInterval[1])){
            newInterval[0] = Math.min(intervals[curIndex][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[curIndex][1], newInterval[1]);
            curIndex++;
        }
        intervalsRes.add(newInterval);

        while(curIndex < numInterval){
            intervalsRes.add(intervals[curIndex++]);
        }

        int[][] ans = new int[intervalsRes.size()][2];
        for(int i=0;i<intervalsRes.size();i++){
            ans[i][0] = intervalsRes.get(i)[0];
            ans[i][1] = intervalsRes.get(i)[1];
        }

        return ans;

       
    }
}