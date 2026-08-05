class Solution {
    void dfsUtil(List<List<Integer>> graph, int curPoint, boolean[] isSus, int[] inDegree){
        isSus[curPoint] = true;
        //System.out.println(curPoint);
        for(int point: graph.get(curPoint)){
            inDegree[point]--;
            if(!isSus[point]){
                //System.out.println("Calling: "+point + " from: "+curPoint);
                dfsUtil(graph,point, isSus, inDegree);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        
        int[] inDegree = new int[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<invocations.length;i++){
            graph.get(invocations[i][0]).add(invocations[i][1]);
            inDegree[invocations[i][1]]++;
        }

        boolean[] isSus = new boolean[n];
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        dfsUtil(graph,k,isSus,inDegree);

        for(int i=0;i<n;i++){
            ans1.add(i);
            //System.out.println("index: " + i +", is Sus: "+isSus[i]);
            if(!isSus[i]){
                ans2.add(i);
            }
        }

        for(int i=0;i<n;i++){
            if(isSus[i]){
                if(inDegree[i] > 0){
                    return ans1;
                }
            }
        }

        return ans2;


    }
}