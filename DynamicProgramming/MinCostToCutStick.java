// LC 1547: MIN COST TO CUT A STICK
// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

import java.util.Arrays;

public class MinCostToCutStick {
  int[][] dp;
  int fun(int cuts[], int i, int j) {
    if(i>j) return 0;
    if(dp[i][j]!=-1) return dp[i][j];
    int res = Integer.MAX_VALUE;
    for(int k=i ; k<=j; k++){
      int cost = cuts[j+1] - cuts[i-1];
      int r = cost + fun(cuts,  i, k-1) + fun(cuts, k+1, j);
      res = Math.min(res, r);
    }
    return dp[i][j] = res;
  }

  public int minCost(int n, int[] cuts) {
    
    int[] c = new int[cuts.length+2];
    c[0] =0 ; c[c.length-1] = n;
    for(int i =0 ; i<cuts.length;i++){
      c[i+1] = cuts[i];
    }
     dp = new int[c.length][c.length];

    for(int i = 0; i < c.length; i++) {
        Arrays.fill(dp[i], -1);
    }
    Arrays.sort(c);
    return fun(c, 1, c.length-2);
  }
}
