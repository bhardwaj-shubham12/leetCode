class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list: node -> [neighbor, price]
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        // minCost array to keep track of the cheapest price to reach each node
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        // Queue stores: [currentNode, currentCost]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});

        int stops = 0;

        // Process up to K stops (which means K + 1 levels of edges)
        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            
            // Iterate through all nodes at the current level
            while (size-- > 0) {
                int[] curr = queue.poll();
                int node = curr[0];
                int cost = curr[1];

                for (int[] neighbor : adj.get(node)) {
                    int nextNode = neighbor[0];
                    int price = neighbor[1];

                    // Only push to queue if this path is cheaper than the recorded minCost
                    if (cost + price < minCost[nextNode]) {
                        minCost[nextNode] = cost + price;
                        queue.offer(new int[] {nextNode, minCost[nextNode]});
                    }
                }
            }
            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}