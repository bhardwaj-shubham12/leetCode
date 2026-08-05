class Solution {
    void dfsUtil(List<List<Integer>> graph, int curPoint, boolean[] isSus){
        isSus[curPoint] = true;
        //System.out.println(curPoint);
        for(int point: graph.get(curPoint)){
            if(!isSus[point]){
                //System.out.println("Calling: "+point + " from: "+curPoint);
                dfsUtil(graph,point, isSus);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }
        for(int i=0;i<invocations.length;i++){
            graph.get(invocations[i][0]).add(invocations[i][1]);
            revGraph.get(invocations[i][1]).add(invocations[i][0]);
        }
        boolean[] isSus = new boolean[n];
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        dfsUtil(graph,k,isSus);

        for(int i=0;i<n;i++){
            ans1.add(i);
            //System.out.println("index: " + i +", is Sus: "+isSus[i]);
            if(!isSus[i]){
                ans2.add(i);
            }
        }

        for(int i=0;i<n;i++){
            if(isSus[i]){
                for(int caller: revGraph.get(i)){
                    if(!isSus[caller]){
                        return ans1;
                    }
                }
            }
        }

        return ans2;
    }
}