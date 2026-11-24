// LC: SUBARRAYS WITH K DIFFERNET INTEGERS
// https://leetcode.com/problems/subarrays-with-k-different-integers/

import java.util.HashMap;

public class SubarraysKDiffIntegers {
    public int slidingwindow(int[] nums, int k) { // for approach 1
        HashMap<Integer, Integer> f = new HashMap<>();
        int low = 0, high = 0, n = nums.length, res = 0;
        for (high = 0; high < n; high++) {
            f.put(nums[high], f.getOrDefault(nums[high], 0) + 1);
            while (f.size() > k) {
                f.put(nums[low], f.get(nums[low]) - 1);
                if (f.get(nums[low]) == 0)
                    f.remove(nums[low]);
                low++;
                if (low > high)
                    break;
            }
            if (low > high)
                continue;
            int total_subarr_end_high = high - low + 1;
            if (f.size() <= k) {
                res += total_subarr_end_high;
            }
        }
        return res;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {

        // approach 1: 
        // int k_ans = slidingwindow(nums, k);
        // int k_1_ans = slidingwindow(nums, k-1);
        // return k_ans - k_1_ans;
         HashMap<Integer, Integer> f = new HashMap<>();
        int low = 0, high = 0, n = nums.length, res = 0 , low_bada =0;
        for(high=0;high<n;high++){
              f.put(nums[high], f.getOrDefault(nums[high], 0) + 1);
            while (f.size() > k) {
                f.put(nums[low], f.get(nums[low]) - 1);
                if (f.get(nums[low]) == 0)
                    f.remove(nums[low]);
                low++;
                low_bada = low;
                if (low > high)
                    break;
            }
            while(f.get(nums[low]) >1){
                f.put(nums[low], f.get(nums[low]) -1);
                low++;
            }
            if(f.size()==k){
                res += (1 + low - low_bada);
            }
        }
        return res;
    }
}
