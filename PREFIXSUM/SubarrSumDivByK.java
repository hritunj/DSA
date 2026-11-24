// LEETCODE: 974
// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
import java.util.*;
public class SubarrSumDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> f = new HashMap<>();
        int res =0 , sum = 0,n = nums.length;
        f.put(0, 1);
        for(int i =0; i<n;i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem<0) rem = rem +k;
            res += f.getOrDefault(rem, 0);
            f.put(rem, f.getOrDefault(rem, 0)+1);
        }
        return res;
    }
}
