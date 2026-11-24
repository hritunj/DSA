// LC: LONGEST SUBARRAY OF 1'S AFTER DELETING ONE ELEMENT
// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
public class LongestSubarray1Deleting1element {
     public int longestSubarray(int[] nums) {
        int[] f = new int[2];
        int n = nums.length, low = 0, high = 0 , res= 0;
        for(high=0;high<n;high++){
            f[nums[high]]++;
            while(f[0] >1){
                f[nums[low]]--;
                low++;
                if(low>high) break;
            }
            int len = high-low+1;
            res = Math.max(res, len-1); 
        }
        return res;
    }
}
