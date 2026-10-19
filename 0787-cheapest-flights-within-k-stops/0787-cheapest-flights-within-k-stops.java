class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        List<Integer> temp;
        for(int i=0;i<flights.length;i++){
            temp = new ArrayList<>();
            temp.add(flights[i][1]);
            temp.add(flights[i][2]);
            graph.get(flights[i][0]).add(temp);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {src, 0});
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        int stops = 0;
        int size;
        int[] topEle;
        while(!q.isEmpty() && stops <= k){
            size = q.size();
            while(size > 0){
                topEle = q.poll();
                for(List<Integer> tempList: graph.get(topEle[0])){
                    if(distance[tempList.get(0)] > topEle[1] + tempList.get(1)){
                        distance[tempList.get(0)] = topEle[1] + tempList.get(1);
                        q.add(new int[]{tempList.get(0), distance[tempList.get(0)]});
                    }
                }
                size--;
            }
            stops++;
        }
        return (distance[dst] == Integer.MAX_VALUE) ? -1: distance[dst]; 
    }
}