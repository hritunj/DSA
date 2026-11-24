// LEETCODE - 1004 MAX CONSECUTIVE 1'S III
//https://leetcode.com/problems/max-consecutive-ones-iii/description/

public class MaxConsecutive1s {
     public int longestOnes(int[] nums, int k) {
        int[] freq = new int[2];
        int low=0,high=0,n=nums.length,max=0;
        for(high=0;high<n;high++){
            freq[nums[high]]++;
            while(freq[0]>k){
                freq[nums[low]]--;
                low++;
            }
            int len = high-low+1;
            max = Math.max(max, len);
        }
        return max;
    }
}
