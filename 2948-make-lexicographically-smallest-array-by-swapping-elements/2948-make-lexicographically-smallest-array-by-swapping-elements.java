class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] mat = new int[nums.length][2];

        for(int i=0;i<nums.length;i++){
            mat[i][0] = nums[i];
            mat[i][1] = i;
        }

        Arrays.sort(mat, (a,b) -> Integer.compare(a[0], b[0]));

        List<PriorityQueue<Integer>> indexes = new ArrayList<>();
        indexes.add(new PriorityQueue<>());
        
        indexes.get(0).add(mat[0][1]);
        int curIndex = 0;
        //System.out.println("Adding index "+mat[0][1]+" to curIndex: "+curIndex);

        for(int i=1;i<nums.length;i++){
            if((mat[i][0] - mat[i-1][0]) > limit){
                curIndex++;
                indexes.add(new PriorityQueue<>());
            }
            //System.out.println("Adding index "+mat[i][1]+" to curIndex: "+curIndex);
            indexes.get(curIndex).add(mat[i][1]);
        }

        curIndex = 0;
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(indexes.get(curIndex).size() == 0){
                curIndex++;
                
            }
            ans[indexes.get(curIndex).poll()] = mat[i][0];
        }

        return ans;
    }
}