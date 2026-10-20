class Solution {
    int nextY[] = {-1, 0, 1, 0};
    int nextX[] = { 0,-1, 0, 1};
    int numRow, numCol;

    boolean isValid(int y, int x){
        if((y < 0) || (x < 0) || (y == numRow) || (x == numCol)) return false;
        return true;
    }

    boolean isValidPath(int mid, List<List<Integer>> grid, int[][] distance){
        boolean[][] visited = new boolean[numRow][numCol];
        visited[0][0] = true;

        Queue<Integer> q  = new ArrayDeque<>();
        if(distance[0][0] < mid) return false;
        q.add(0);

        while(!q.isEmpty()){
            int top = q.poll();
            int topRow = top / numCol;
            int topCol = top % numCol;

            if((topRow == numRow-1) && (topCol == numCol - 1)) return true;

            for(int i=0;i<4;i++){
                int nextRow = topRow + nextY[i];
                int nextCol = topCol + nextX[i];

                if((isValid(nextRow, nextCol)) && 
                (visited[nextRow][nextCol] == false) && 
                (grid.get(nextRow).get(nextCol) != 1) &&
                (distance[nextRow][nextCol] >= mid)){
                    visited[nextRow][nextCol] = true;
                    q.add(nextRow * numCol + nextCol);
                }
            }
        }
        return false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        numRow = grid.size();
        numCol = grid.get(0).size();

        if(
            (grid.get(0).get(0) == 1) ||
            (grid.get(numRow - 1).get(numCol - 1) == 1)
        )
        {
            return 0;
        }
        
        int[][] distance = new int[numRow][numCol];
        for(int i=0;i<numRow;i++){
            for(int j=0;j<numCol;j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Integer> thiefQ = new ArrayDeque<>();
        for(int i=0;i<numRow;i++){
            for(int j=0;j<numCol;j++){
                if(grid.get(i).get(j) == 1){
                    thiefQ.add(i * numCol + j);
                    distance[i][j] = 0;
                }
            }
        }


        int l = 0;
        int r = 0;
        while(!thiefQ.isEmpty()){
            int top = thiefQ.poll();
            int topRow = top / numCol;
            int topCol = top % numCol;

            for(int i=0;i<4;i++){
                int nextRow = topRow + nextY[i];
                int nextCol = topCol + nextX[i];

                if(isValid(nextRow, nextCol)){
                    if(distance[nextRow][nextCol] == Integer.MAX_VALUE){
                        distance[nextRow][nextCol] = distance[topRow][topCol] + 1;
                        thiefQ.add(nextRow * numCol + nextCol);
                        r = Math.max(r, distance[nextRow][nextCol]);
                    }
                }
            }
        }

        int mid;
        int ans = 0;
        while(l <= r){
            mid = l + (r - l)/2;
            if(isValidPath(mid, grid, distance)){
                l = mid + 1;
                ans = Math.max(mid, ans);
            }
            else{
                r = mid - 1;
            }
        }

        return ans;

    }
}