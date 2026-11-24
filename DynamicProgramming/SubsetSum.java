// GFG: SUBSET SUM PROBLEM
// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1


public class SubsetSum {
    static boolean fun(int[] arr, int sum , int i){
        if(i==arr.length && sum!=0) return false;
        if(sum==0) return true;
        if(sum<arr[i]) return fun(arr, sum, i+1);
        boolean c1 = fun(arr, sum-arr[i], i+1);
        boolean c2 = fun(arr, sum, i+1);
        return c1 || c2; 
    }
     static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int j= 0; j<=sum; j++){
            dp[n][j] = false;
        }
        dp[n][0] = true;
        for(int i= n-1 ; i>=0; i--){
            for(int j=0; j<=sum; j++){
                if(arr[i] > j){
                    dp[i][j] = dp[i+1][j];
                } else{
                    dp[i][j] = dp[i+1][j-arr[i]] || dp[i+1][j];
                }
            }
        }
        return dp[0][sum];
    }
}
