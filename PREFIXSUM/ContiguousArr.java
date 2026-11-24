// LEETCODE 525: CONTIGUOUS ARRAY
// https://leetcode.com/problems/contiguous-array/
import java.util.*;
public class ContiguousArr {
     public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        int zero = 0 , one = 0, n = nums.length , res =0 ;
        for(int i = 0; i<n;i++){
            if(nums[i]==0) {zero++;} else {one++;}
            int diff = one -zero;
            if(diff ==0) {
                res = Math.max(res, i+1);
                continue;
            }
            if(!f.containsKey(diff)){
                f.put(diff, i);
                continue;
            } else{
                int idx = f.get(diff);
                int len = i - idx;
                res = Math.max(len,res);
            }

        }
        return res;
    }
}
