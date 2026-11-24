// LEETCODE- 209  MINIMUM SIZE SUBARRAY SUM : return min length of subarray whose sum >= target
// https://leetcode.com/problems/minimum-size-subarray-sum/

public class MinSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int low=0 , high =0, res= Integer.MAX_VALUE, sum =0 , n=nums.length;
        while(high<n){ // https://www.youtube.com/watch?v=DL8LSXUsfWE&t=2500s   qn:2 
            // hiring : 
            sum += nums[high];
            // jab tak kaam ho , fire:

            while(sum>=target){
                int len = high-low+1; // length of subarray
                sum = sum - nums[low];
                res = Math.min(len, res);
                low++;
            }
            high++;
        }
        if(res==Integer.MAX_VALUE) return 0;
        return res;
    }
}
