class Solution {
    public int maxProfit(int[] prices) {
        int[] ahead = new int[2];
        int[] cur = new int[2];
        ahead[0] = ahead[1] = 0;
        int n = prices.length;

        int profit = 0;
         for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { 
                    profit = Math.max(0 + ahead[0], -prices[ind] + ahead[1]);
                }

                if (buy == 1) { 
                    profit = Math.max(0 + ahead[1], prices[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            System.arraycopy(cur, 0, ahead, 0, 2);
        }
        return cur[0]; 
    }
}