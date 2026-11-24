// LC: SUBSETS 2 
// https://leetcode.com/problems/subsets-ii/

import java.util.*;

public class Subsets2 {
    static void fun(int[] a, int start , List<Integer> temp, List<List<Integer>> res){
        
            res.add(new ArrayList<>(temp));

        for(int i = start; i<a.length;i++){
            if(i>start && a[i] == a[i-1]) continue;
            temp.add(a[i]);
            fun(a, i+1, temp, res);
            temp.removeLast();
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        fun(nums, 0, temp, res);
        return res;
    }
    public static void main(String[] args) {
        int[] a = {1,2,2};
        System.out.println(subsetsWithDup(a));
    }
}
