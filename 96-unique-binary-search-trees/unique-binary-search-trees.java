class Solution {
    public int numTrees(int n) {
          int[] dp = new int[n + 1];
      
        // There is one unique BST for a tree with zero nodes, which is an empty tree
        dp[0] = 1;
      
        // Iterate over each count of nodes from 1 to n
        for (int nodes = 1; nodes <= n; ++nodes) {
            for (int root = 0; root < nodes; ++root) {

                dp[nodes] += dp[root] * dp[nodes - root - 1];
            }
        }
      
        return dp[n];
    }
}