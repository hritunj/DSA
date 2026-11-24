// LC 930: BINARY SUBARRAY WITH GIVEN SUM
// https://leetcode.com/problems/binary-subarrays-with-sum/

import java.util.HashMap;

public class BinarySubarrSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        // PREFIX SUM APPROACH: 
        // int res = 0;
        // int sum = 0;
       
        // HashMap<Integer, Integer> f = new HashMap<>();
        //  f.put(0,1);
        // for (int i = 0; i < n; i++) {
        //     sum += nums[i];
        //     int qn = sum - goal;
        //     int c = f.getOrDefault(qn, 0);
        //     res += c;
        //     f.put(sum, f.getOrDefault(sum, 0) + 1);
        // }
        // return res;

        int low =0, high =0;
        int count=0; int sum=0; int zeroes= 0; // zeroes count the current sliding window's prefix zeroes
        while(high<n){
            sum+= nums[high];
            while(low<high && (nums[low] ==0 || sum>goal)){ // we did low<high instead of <= because if there is only one element we do not want to shrink 
                if(nums[low] ==0){
                    zeroes++;
                } else{
                    zeroes =0;
                }
                sum -= nums[low];
                low++;
            }
            if(sum==goal){
                count = count + 1 + zeroes;
            }
        }
        return count;
    }
}
