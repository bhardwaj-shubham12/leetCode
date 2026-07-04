class Solution {
    int findRoot(int[] root, int node){
        if(root[node] == node){
            return node;
        }
        root[node] = findRoot(root, root[node]);
        return root[node];
    }
    public int minScore(int n, int[][] roads) {
        int[] root = new int[n+1];

        for(int i=0;i<=n;i++){
            root[i] = i;
        }

        for(int[] road: roads){
            root[findRoot(root, road[0])] = findRoot(root,road[1]);
        }

        int res = 10001;
        for(int[] road: roads){
            if(findRoot(root, road[0]) == findRoot(root, 1)){
                res = Math.min(res, road[2]);
            }
        }

        return res;
    }
}