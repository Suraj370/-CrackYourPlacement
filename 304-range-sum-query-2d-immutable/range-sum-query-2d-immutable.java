class NumMatrix {
    
    private int[][]data;
        
     public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
         data = new int[matrix.length +1][matrix[0].length+1];
         for(int row = 0; row<matrix.length;row++){
             for(int col = 0; col < matrix[0].length;col++){
                 data[row + 1][col + 1] = data[row  + 1][col] + data[row][col + 1] + 
                     matrix[row][col] - data[row][col];
             }
         }
        
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return data[row2 + 1][col2 + 1] - data[row1][col2 + 1] - data[row2 + 1][col1] +
            data[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */