class NumMatrix {
    int[][] prefixSum;
    int numRows, numCols;

    public NumMatrix(int[][] matrix) {
        numRows = matrix.length;
        numCols = matrix[0].length;
        prefixSum = new int[numRows][numCols];

        prefixSum[0][0] = matrix[0][0];

        for(int i=1;i<numRows;i++){
            prefixSum[i][0] = prefixSum[i-1][0] + matrix[i][0];
        }

        for(int j=1;j<numCols;j++){
            prefixSum[0][j] = prefixSum[0][j-1] + matrix[0][j];
        }

        for(int i=1;i<numRows;i++){
            for(int j=1;j<numCols;j++){
                prefixSum[i][j] = prefixSum[i][j-1] + matrix[i][j] + prefixSum[i-1][j] - prefixSum[i-1][j-1];
            }
        }

        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                System.out.print(prefixSum[i][j]+", ");
            }
            System.out.println();
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total   = prefixSum[row2][col2];
        int left    = (col1 > 0) ? prefixSum[row2][col1 - 1] : 0;
        int up      = (row1 > 0) ? prefixSum[row1 - 1][col2] : 0;
        int overLap = ((row1 > 0) && (col1 > 0)) ? prefixSum[row1 - 1][col1 - 1] :0;

        return total - left - up + overLap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */