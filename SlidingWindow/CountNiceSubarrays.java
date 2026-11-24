// LC : COUNT NUMBER OF NICE SUBARRAYS
// https://leetcode.com/problems/count-number-of-nice-subarrays/

import java.util.HashMap;

public class CountNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int low = 0, high = 0;
        int count = 0;
        int n = nums.length; int odd = 0; 
       
        for (high = 0; high < n; high++) {

            if(nums[high] % 2!=0) odd++;
            while(low<=high && odd>k){
                if(nums[low] %2!=0) odd--;
                low++;
            }
            if(odd==k){
                int even =0; 
                while(low<=high && nums[low] %2==0){
                    even++;
                    low++;
                }
                count = count + even +1;
            }
        }
        return count;
    }
}
