class Solution {
    // Define the modulus constant for the problem
    private static final int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String s) {
        int n = s.length(); 
      
        long[][][] dp = new long[n][n][4];
      
        for (int i = 0; i < n; ++i) {
            dp[i][i][s.charAt(i) - 'a'] = 1;
        }
      
        for (int len = 2; len <= n; ++len) {

            for (int start = 0; start + len <= n; ++start) {
                int end = start + len - 1; 

                for (char c = 'a'; c <= 'd'; ++c) {
                    int charIndex = c - 'a';

                    if (s.charAt(start) == c && s.charAt(end) == c) {
                        dp[start][end][charIndex] = 2 + dp[start + 1][end - 1][0]
                            + dp[start + 1][end - 1][1] + dp[start + 1][end - 1][2]
                            + dp[start + 1][end - 1][3];
                        dp[start][end][charIndex] %= MOD; 
                    }
                    else if (s.charAt(start) == c) {
                        dp[start][end][charIndex] = dp[start][end - 1][charIndex];
                    }
                    else if (s.charAt(end) == c) {
                        dp[start][end][charIndex] = dp[start + 1][end][charIndex];
                    }
                    else {
                        dp[start][end][charIndex] = dp[start + 1][end - 1][charIndex];
                    }
                }
            }
        }
      
        long result = 0;
        for (int k = 0; k < 4; ++k) {
            result += dp[0][n - 1][k];
        }
      
        return (int) (result % MOD); 
    }
}