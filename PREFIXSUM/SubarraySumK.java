// LEETCODE 560: SUBARRAY SUM EQUALS K
// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;

public class SubarraySumK {
     public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> f = new HashMap<>();
        int sum = 0; int res = 0;
        f.put(sum, 1);
        for(int i = 0; i< nums.length ; i++){
            sum += nums[i];
            res += f.getOrDefault(sum-k, 0);
            f.put(sum, f.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
