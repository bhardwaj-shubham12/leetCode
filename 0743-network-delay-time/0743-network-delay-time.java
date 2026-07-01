class Solution {
    class Node implements Comparable<Node>{
        int vertex;
        int distance;

        Node(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n1){
            if(this.distance == n1.distance){
                return Integer.compare(this.vertex, n1.vertex);
            }
            return Integer.compare(this.distance, n1.distance);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer > > > graph = new ArrayList<>();
        
        for(int i=0;i<n + 1;i++){
            graph.add(new ArrayList<>());
        }

        int source,dest,weight;
        //Create graph
        for(int i=0;i<times.length;i++){
            source = times[i][0];
            dest = times[i][1];
            weight = times[i][2];
            List<Integer> edge = new ArrayList<>();
            edge.add(dest);
            edge.add(weight);
            graph.get(source).add(edge);
        }

        int[] distance = new int[n + 1];
        for(int i=0;i<=n;i++){
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        pq.add(new Node(k,0));
        distance[k] = 0;
        int cost = 0;

        while(!pq.isEmpty()){
            Node top = pq.poll();
            for(List<Integer> edge: graph.get(top.vertex)){
                if(distance[edge.get(0)] > top.distance + edge.get(1)){
                    pq.add(new Node(edge.get(0), top.distance + edge.get(1) ));
                    distance[edge.get(0)] = top.distance + edge.get(1);
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            cost = Math.max(cost, distance[i]);
        }
        return cost;
    }
}