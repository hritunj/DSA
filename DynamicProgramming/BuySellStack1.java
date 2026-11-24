// LC 216: BEST TIME TO BUY AND SELL STOCKS
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BuySellStack1 {
    int[][] dp; 
    int fun(int[] prices , int i, int k){
        if(i==prices.length) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        if(k==2){
            // buy or nothing
            int c1 = fun(prices, i+1, k-1) - prices[i];
            int c2 = fun(prices, i+1, k);
            return dp[i][k]= Math.max(c1, c2);
        } else{
            // sell or nothing
             int c1 = fun(prices, i+1, k-1) + prices[i];
            int c2 = fun(prices, i+1, k);
            return dp[i][k]= Math.max(c1, c2);
        }
    }
     public int maxProfit(int[] prices) {
        // dp = new int[prices.length+1][3];
        // for(int i=0; i<prices.length+1; i++) Arrays.fill(dp[i], -1);
        // for(int i=0 ; i<prices.length; i++){
        //     dp[i][0] =0;
        // }
        // int k =2; 
        // int gain = fun(prices, 0, k);
        // return gain;
         int min = prices[0] , gain =0;
        for(int i=0 ; i<prices.length;i++){
            min = Math.min(min, prices[i]);
            gain = Math.max(gain, prices[i]-min);
        }
        return gain;
    }
}
