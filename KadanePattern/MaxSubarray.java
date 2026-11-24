// LEETCODE - 53 MAXIMUM SUBARRAY
// https://leetcode.com/problems/maximum-subarray/
public class MaxSubarray {
     public int maxSubArray(int[] nums) {
        int bestending = nums[0];
        int result = 0;
        for(int i= 1; i<nums.length ; i++){
            int v1 = bestending + nums[i];
            int v2 = nums[i];
            bestending = Math.max(v1, v2);
            result = Math.max(bestending , result);
        }
        return result;
    }
}
