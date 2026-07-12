class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n == 0) return new int[]{}; 
        int[][] matrix = new int[n][3];

        for(int i=0;i<n;i++){
            matrix[i][0] = i;
            matrix[i][1] = arr[i];
            matrix[i][2] = -1;
        }

        Arrays.sort(matrix, (a,b) -> Integer.compare(a[1], b[1]));

        matrix[0][2] = 1;
        for(int i=1;i<n;i++){
            if(matrix[i][1] > matrix[i-1][1]){
                matrix[i][2] = matrix[i-1][2] + 1;
            }
            else{
                matrix[i][2] = matrix[i-1][2];
            }
        }

        int[] rank = new int[n];
        for(int i=0;i<n;i++){
            rank[matrix[i][0]] = matrix[i][2];
        }

        return rank;
    }
}