// LC: SPLIT ARRAY LARGEST SUM
// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrLargestSum {
    boolean check(int[] nums, int guess, int k){
        int count =1; int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] +sum <=guess ){
                 sum += nums[i];
            } else{
                count++;
                sum = nums[i];
                if(count>k) return false;
            }
        }
        return count<= k;
    }
     public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int  low =nums[0] , high =0; int res=0; 
        for(int i=0; i<n; i++){
             high+=nums[i];
             low = Math.max(low, nums[i]);
        }
        while(low<=high){ // logn
            int guess = low + (high-low)/2;
            if(check(nums, guess, k)){
                res = guess;
                high = guess-1;
            } else{
                low = guess+1;
            }
        }
        return res;
    }
}
