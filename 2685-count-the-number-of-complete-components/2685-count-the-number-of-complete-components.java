class Solution {
    private void dfsUtil(List<List<Integer>>graph, int vertex, boolean[] visited, List<Integer> temp, RetVal retVal){
        visited[vertex] = true;
        temp.add(vertex);
        for(int ele: graph.get(vertex)){
            if(ele > vertex)
                retVal.numEdge++;
            if(!visited[ele]){
                dfsUtil(graph, ele, visited, temp, retVal);
            }
        }
    }
    class RetVal{
        int numEdge;
        RetVal(int numEdge){
            this.numEdge = numEdge;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int numComp = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        boolean[][] isEdgeConnect = new boolean[n][n];

        //O(M)
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            isEdgeConnect[edges[i][0]][edges[i][1]] = true;
            isEdgeConnect[edges[i][1]][edges[i][0]] = true;
        }

        List<Integer> temp;
        boolean allConnect = true;
        int numEdge = 0;
        RetVal retVal = new RetVal(0);
        //O(N)
        for(int i=0;i<n;i++){
            if(!visited[i]){
                temp = new ArrayList<>();
                retVal.numEdge = 0;
                dfsUtil(graph, i, visited, temp, retVal);
                //System.out.println(temp.size() + ", " +retVal.numEdge);
                if(retVal.numEdge == (((temp.size()) * (temp.size() -1 )) / 2)){
                    numComp++;
                }
            }
        }

        return numComp;
    }
}