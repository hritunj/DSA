// LC 39: COMBINATION SUM
// https://leetcode.com/problems/combination-sum/description/

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> fun (int[] candidates , int target, int i , int sum , ArrayList<Integer> temp, List<List<Integer>> res){
        if(i==candidates.length){
            if(sum==target) res.add(new ArrayList<>(temp));
            return res;
        }
        // choice 1: not taking
        fun(candidates, target, i+1, sum, temp, res);
        // choice 2: taking
        if(sum+ candidates[i] <= target){
            temp.add(candidates[i]);
            sum += candidates[i];
            fun(candidates, target, i, sum, temp, res);
            sum -= candidates[i];
            temp.removeLast();
        }
        return res;

    }
      public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        return fun(candidates, target, 0, 0, temp, res);
    }
}
