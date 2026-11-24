import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        int min_diff = Integer.MAX_VALUE;
        int res_sum = 0;

        for (int i = 0; i < n-2; i++) {
            int left = i+1;
            int right = n - 1;
            int required = target - nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                int diff = Math.abs(sum - required);

                if (sum == required) {
                    // we found closest sum , i.e., target itself , so return sum
                    return sum + nums[i];
                } else if (sum < required) {
                    if (min_diff > diff) {
                        min_diff = diff;
                        res_sum = sum + nums[i];
                    }
                    left++;
                } else {
                    if (min_diff > diff) {
                        min_diff = diff;
                        res_sum = sum + nums[i];
                    }
                    right--;
                }

            }
            
        }
        return res_sum;
    }
}
