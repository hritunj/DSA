// 3SUM- LEETCODE -15
// https://leetcode.com/problems/3sum/description/?envType=problem-list-v2&envId=two-pointers

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int target = -1 * nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else { // sum==target
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left<n && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]) right--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
