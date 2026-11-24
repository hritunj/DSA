// LC 46: PERMUTATIONS
// https://leetcode.com/problems/permutations/description/

import java.util.*;

public class Permutations {
    public List<List<Integer>> fun(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(Arrays.stream(nums).boxed().toList());
            return res;
        }
        for (int i = idx; i < nums.length; i++) {
            int t = nums[idx];
            nums[idx] = nums[i];
            nums[i] = t;
            fun(nums, idx + 1, res);
             t = nums[idx];
            nums[idx] = nums[i];
            nums[i] = t;
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return fun(nums, 0, res);
    }
}
