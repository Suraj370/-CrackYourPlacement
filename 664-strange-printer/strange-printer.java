class Solution {
    public int strangePrinter(String s) {
        final int INFINITY = Integer.MAX_VALUE / 2;
        int length = s.length();
        int[][] dp = new int[length][length];
      
        for (int[] row : dp) {
            Arrays.fill(row, INFINITY); 
        }
      
        for (int i = length - 1; i >= 0; --i) { 
            dp[i][i] = 1; 
          
            for (int j = i + 1; j < length; ++j) { 
                if (s.charAt(i) == s.charAt(j)) { 
                    dp[i][j] = dp[i][j - 1];
                } else {
                    for (int k = i; k < j; ++k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]); 
                    }
                }
            }
        }
      
        return dp[0][length - 1]; 
    }
}