// GFG: 0/1 KNAPSACK 
// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

import java.util.Arrays;

public class Knapsach_01 {
    int[][] dp; 
    int fun(int w , int[] val, int[] wt  , int i){
        if(i==val.length || w ==0 ) return 0;
        if(dp[i][w] != -1) return dp[i][w];
        if(w<wt[i]) return dp[i][w]= fun(w, val, wt, i+1);
        int c1 = val[i] + fun(w - wt[i], val, wt, i+1);
        int c2 = fun(w, val, wt, i+1);
        return dp[i][w] = Math.max(c1, c2);
    }
    public int knapsack(int W, int val[], int wt[]) {
        dp = new int[val.length][W+1];
        for(int i=0; i<val.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return fun(W, val, wt, 0);
        
    }
}
