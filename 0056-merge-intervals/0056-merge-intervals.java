class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x,y) -> Integer.compare(x[0], y[0]));

        List<int[]> mergedList = new LinkedList<>();
        mergedList.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] curInterval = intervals[i];
            int[] lastMerged = mergedList.getLast();

            if(curInterval[0] <= lastMerged[1]){
                lastMerged[1] = Math.max(curInterval[1], lastMerged[1]);
            }
            else{
                mergedList.add(curInterval);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }
}