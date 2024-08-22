class Solution {
    public int coinChange(int[] coins, int amount) {
         final int INF = 1 << 30;

    
        int[] dp = new int[amount + 1];


        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int coin : coins) {

            for (int currentAmount = coin; currentAmount <= amount; ++currentAmount) {
          
                dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
            }
        }


        return dp[amount] >= INF ? -1 : dp[amount];
    }
}