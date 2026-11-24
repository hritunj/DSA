// LC: SUBSETS
// https://leetcode.com/problems/subsets/description/

import java.util.*;

public class Powerset {
    List<List<Integer>> res = new ArrayList<>();
    List<List<Integer>> fun(int[] nums , int i, List<Integer> temp){
        if(i==nums.length){
            res.add(new ArrayList<>(temp));
            return res;
        } 
        temp.add(nums[i]);
        fun(nums, i+1, temp);
        temp.removeLast();

        fun(nums, i+1, temp);
        return res;
    }
     public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        return fun(nums, 0,temp );
    }
}
