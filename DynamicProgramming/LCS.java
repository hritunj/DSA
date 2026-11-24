// LC: LONGEST COMMON SUBSEQUENCE
// https://leetcode.com/problems/longest-common-subsequence/description/

import java.util.Arrays;

public class LCS {
    int[][] dp ;
    int fun (String text1, String text2, int i, int j){
        if(i==text1.length() || j == text2.length()) return 0;
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + fun(text1, text2, i+1, j+1);
        }
        int c1 = fun(text1, text2, i+1, j);
        int c2 = fun(text1, text2, i, j+1);
        return Math.max(c1, c2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() , m = text2.length();
        dp = new int[n+1][m+1];
        for(int i=0 ;i<n+1; i++) Arrays.fill(dp[i], -1);
        for(int i =0 ; i< n+1 ; i++) dp[i][m] = 0;
        for(int j=0; j<m+1 ; j++) dp[n][j] =0;
        for(int i = n-1; i>=0 ; i--){
            for(int j = m-1 ; j>=0 ; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else{
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
