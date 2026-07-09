class Solution {
    int findParent(int node1, int[] parent){
        if(parent[node1] != node1){
            parent[node1] = findParent(parent[node1], parent);
        }
        return parent[node1];
    }

    void mergeNodes(int n1, int n2, int[] parent, int[] rank){
        if(n1 == n2) return;

        int p1 = findParent(n1, parent);
        int p2 = findParent(n2, parent);

        if(p1 == p2) return;
        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
        }
        else if(rank[p1] < rank[p2]){
            parent[p1] = p2;
        }
        else{
            parent[p2] = p1;
            rank[p1]++;
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        //create graph
        //use union find to create components
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int left = 0;
        int right = 0;
        //O(N)
        for(int i=0;i<n-1;i++){
            if((nums[i+1] - nums[i]) <= maxDiff){
                mergeNodes(i, i+1, parent, rank);
            }
        }

        // O(M)
        boolean[] ans = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i] = (parent[queries[i][0]] == parent[queries[i][1]]) ? true: false;
        }

        return ans;
    }
}