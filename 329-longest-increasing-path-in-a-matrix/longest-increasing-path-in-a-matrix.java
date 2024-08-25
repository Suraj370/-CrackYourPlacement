class Solution {
    private int numRows;
    private int numCols;
    private int[][] grid; 
    private int[][] dp; 

    public int longestIncreasingPath(int[][] matrix) {
        numRows = matrix.length;
        numCols = matrix[0].length;
        dp = new int[numRows][numCols];
        this.grid = matrix;
        int longestPath = 0;

        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                longestPath = Math.max(longestPath, dfs(i, j));
            }
        }
      
        return longestPath;
    }

    private int dfs(int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int[] directions = {-1, 0, 1, 0, -1};
      
        for (int k = 0; k < 4; k++) {
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];

            if (nextRow >= 0 && nextRow < numRows && nextCol >= 0 && nextCol < numCols && grid[nextRow][nextCol] > grid[row][col]) {
                dp[row][col] = Math.max(dp[row][col], dfs(nextRow, nextCol));
            }
        }

        return ++dp[row][col];
    }
}
