// LEETCODE: 18 4SUM
// https://leetcode.com/problems/4sum/description/

import java.util.*;

public class Foursum {
     public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ;i<n-3 ;i++){
            long target1 = (long) target - nums[i];
            if(i>0 && nums[i] == nums[i-1]) continue;  // skipping duplicate i
            for(int j = i+1 ; j<n-2;j++){
                 if(j>i+1  && nums[j] == nums[j-1]) continue;  // skipping duplicate j 
                long target2 = target1 - nums[j];
                int left = j+1;
                int right = n-1;
                while(left<right){
                    long sum =(long) nums[left] + nums[right];
                    if(sum<target2){ 
                        left++;
                    } else if (sum>target2){
                        right--;
                    } else{
                        // sum == target
                        List<Integer> pairs = new ArrayList<>();
                        pairs.add(nums[i]);
                        pairs.add(nums[j]);
                        pairs.add(nums[left]);
                        pairs.add(nums[right]);
                        res.add(pairs);
                        left++;
                        right--;
                        while(left<n && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(right>=0 && nums[right] == nums[right+1]){
                            right--;
                        }

                    }
                }
            }
        }
        return res;
    }
}
