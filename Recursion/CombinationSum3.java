// LC: COMBINATION SUM III
// https://leetcode.com/problems/combination-sum-iii/

import java.util.*;

public class CombinationSum3 {
    void fun(int[] a , int start, int target, List<Integer> temp, int k , List<List<Integer>> res){
        if(target==0 && k==0){
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(k==0) return ;
        for(int i= start; i<a.length;i++){
            if(i>start && a[i]==a[i-1]) continue;
            if(a[i] > target) break;
            temp.add(a[i]);
            fun(a, i+1, target-a[i], temp, k-1, res);
            temp.remove(temp.size()-1);
        }
    }
     public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] a = {1,2,3,4,5,6,7,8,9};
        fun(a, 0, n, temp, k, res);
        return res;
    }
}
