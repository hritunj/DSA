// LC 494: TARGET SUM
// https://leetcode.com/problems/target-sum/description/
public class TargetSum {
     public int findTargetSumWays(int[] nums, int target) {
        int s =0; 
        for(int i=0; i<nums.length;i++) s+=nums[i];
          int n = nums.length; int sum = (target+s)/2; 
          if((target+s)%2!=0) return  0;
          if(Math.abs(target) > s) return  0;
        int[][] dp = new int[n+1][sum+1];
        for(int j= 0; j<=sum; j++){
            dp[n][j] = 0;
        }
        dp[n][0] = 1;
        for(int i= n-1 ; i>=0; i--){
            for(int j=0; j<=sum; j++){
                if(nums[i] > j){
                    dp[i][j] = dp[i+1][j];
                } else{
                    dp[i][j] = dp[i+1][j-nums[i]] + dp[i+1][j];
                }
            }
        }
        return dp[0][sum];
    }
}
