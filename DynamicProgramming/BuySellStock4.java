// LC: BUY SELL STOCK 4
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class BuySellStock4 {
      public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length + 1][k*2 +1 ];
        int n = prices.length;
        // for(int i=0; i<prices.length+1; i++) Arrays.fill(dp[i], -1);

        k=k*2;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < k + 1; j++) {
                if (j == 0)
                    continue;
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j - 1] - prices[i], dp[i + 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j - 1] + prices[i], dp[i + 1][j]);
                }
            }
        }
        return dp[0][k];
    }
}
