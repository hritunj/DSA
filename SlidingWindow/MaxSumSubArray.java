// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

public class MaxSumSubArray{

    public int maxSubarraySum(int[] arr, int k){

        int n = arr.length;
        if(n<k) return 0; int maxSum = Integer.MIN_VALUE;
        int windowSum =0;
        // first window sum
        for(int i=0; i<k; i++) windowSum+=arr[i];
        maxSum = windowSum;
        // new window sum
        for(int i=k; i<n; i++){
            windowSum+= arr[i] - arr[i-k]; 
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
        
    }
    public static void main(String[] args) {
        
    }
}