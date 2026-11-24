// LC: COMBINATION SUM II
// https://leetcode.com/problems/combination-sum-ii/

import java.util.*;

public class CombinationSum2 {

    void fun(int[] candidates, int i, int target , List<Integer> temp, List<List<Integer>> ans) {
       if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
       }

       for(int j = i; j<candidates.length;j++){

            if(j>i && candidates[j] == candidates[j-1]) continue;

            if(target < candidates[j]) break;

            temp.add(candidates[j]);
            fun(candidates, j+1, target-candidates[j], temp, ans);
            temp.remove(temp.size()-1);
       }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        fun(candidates, 0, target, temp, res);
        return res;
    }
}
