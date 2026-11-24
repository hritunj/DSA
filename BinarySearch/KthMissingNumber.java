// LC: FIND KTH MISSING POSITIVE NUMBER
// https://leetcode.com/problems/kth-missing-positive-number/

public class KthMissingNumber {
    public int findKthPositive(int[] arr, int k) {
        // APPROACH 1: O(n)
        // int n = arr.length, num = 1, i = 0;
        // while (i < n && k > 0) {
        // if (arr[i] == num) {
        // i++;

        // } else{
        // k--;
        // }
        // num++;
        // }
        // while(k>0){
        // k--;
        // num++;
        // }
        // return num-1;

        // APPROACH 2: BINARY SEARCH O(logn)
        int n = arr.length;
        int low =0 , high = n-1;
        while(low<=high){
            int guess = (low+high)/2;
            int missing = arr[guess] - (guess+1);
            if(missing<k){
                low = guess+1;
            } else{
                high = guess-1;
            }
        }
        return low+k;
    }
}
