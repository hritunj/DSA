// LC 1283: FIND SMALLEST DIVISOR GIVEN A THESHOLD
// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
public class SmallestDivisorGivenThreshold {
    boolean fun(int[] nums, int threshold, int guess){
        long sum =0 ; 
        for(int i=0; i<nums.length;i++){
            sum += Math.ceilDiv(nums[i], guess);
            if(sum>threshold) break;
        }
        return sum<=threshold;
    }
     public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length; int res = -1; 
        int low= 1 , high = nums[0];
        for(int i=0; i<n;i++) high = Math.max(high, nums[i]);
        while (low<=high) {
            int guess = low + (high-low)/2;
            if(fun(nums, threshold, guess)){
                res = guess;
                high = guess-1;
            } else{
                low = guess+1;
            }
        }
        return res;
    }
}
