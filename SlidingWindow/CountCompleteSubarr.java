// LC: COUNT COMPLETE SUBARRAYS IN AN ARRAY
// https://leetcode.com/problems/count-complete-subarrays-in-an-array/
import java.util.HashMap;

public class CountCompleteSubarr {
    public int countCompleteSubarrays(int[] nums) {
          HashMap<Integer, Integer> f = new HashMap<>();
        int low = 0, high = 0, n = nums.length, res = 0 , low_bada =0 ;
        for(int i=0;i<n;i++) if(!f.containsKey(nums[i])) f.put(nums[i] ,1);
        int k = f.size();
        f.clear();
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
