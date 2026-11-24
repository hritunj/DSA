// LC 416: PARTITION EQUAL SUM
// https://leetcode.com/problems/partition-equal-subset-sum/description/
public class PartitionEqualSum {
     public boolean canPartition(int[] nums) {
        int s = 0;
        for(int i=0 ; i<nums.length;i++){
            s += nums[i];
        }
        if(s%2!=0) return  false;
        int n = nums.length; int sum = s/2; 
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[n][0] = true;
        for(int i= n-1 ; i>=0; i--){
            for(int j=0; j<=sum; j++){
                if(nums[i] > j){
                    dp[i][j] = dp[i+1][j];
                } else{
                    dp[i][j] = dp[i+1][j-nums[i]] || dp[i+1][j];
                }
            }
        }
        return dp[0][sum];
    }
}
