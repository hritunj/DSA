// LC 62: UNIQUE PATHS
// https://leetcode.com/problems/unique-paths/description/

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++) Arrays.fill(dp[i], -1);
        dp[m-1][n-1] = 1; 
        for(int i=0; i< m+1 ; i++ ) dp[i][n] = 0; 
        for(int j=0; j< n+1 ; j++ ) dp[m][j] = 0; 
        for(int i=m-1 ; i>=0; i--){
            for(int j= n-1; j>=0 ; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
