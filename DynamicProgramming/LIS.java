// LC 300: LONGEST INCREASING SUBSEQUENCE (LIS)
// https://leetcode.com/problems/longest-increasing-subsequence/description/
// import java.util.*;
public class LIS {
    int[][] dp; 
    int fun(int[] nums, int i, int prev){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1] !=-1 ) return dp[i][prev+1];
        if(prev==-1 || nums[i] > nums[prev]){
            int c1 = 1 + fun(nums, i+1, i);
            int c2 = fun(nums, i+1, prev);
            return dp[i][prev+1] = Math.max(c1, c2);
        }
        return dp[i][prev+1] = fun(nums, i+1, prev);
       
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp = new int[nums.length+1][nums.length+1];
        // for(int i=0; i< nums.length;i++) Arrays.fill(dp[i], -1);
        // return fun(nums, 0, -1);


        // TABULATION: 
        int[] res = new int[n];
        for(int i=0; i<n;i++){
            res[i] = 1;
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]) {
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
        }
        int ress = 0;
        for(int i=0 ;i<n;i++) ress = Math.max(ress, res[i]);
        return  ress;
    }
}
