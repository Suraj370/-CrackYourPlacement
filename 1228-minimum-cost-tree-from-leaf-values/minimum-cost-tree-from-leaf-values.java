class Solution {
    public int mctFromLeafValues(int[] arr) {
         int size = arr.length; 
      
        int[][] dp = new int[size][size]; 
        int[][] maxLeafValue = new int[size][size]; 
      
        
        for (int i = size - 1; i >= 0; --i) {
            maxLeafValue[i][i] = arr[i]; 
            for (int j = i + 1; j < size; ++j) {
                maxLeafValue[i][j] = Math.max(maxLeafValue[i][j - 1], arr[j]);
                dp[i][j] = Integer.MAX_VALUE; 
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], 
                                         dp[i][k] + dp[k + 1][j] + maxLeafValue[i][k] * maxLeafValue[k + 1][j]);
                }
            }
        }

        return dp[0][size - 1];
    }
}