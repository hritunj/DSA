// LC: MAJORITY ELEMENT 2
// https://leetcode.com/problems/majority-element-ii/

import java.util.*;

public class MajorityElement2 {
      public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int cand1 = Integer.MIN_VALUE , cand2 = Integer.MIN_VALUE;
        int c1 = 1 , c2 =1;
        for(int i=0; i<n;i++){
            if(cand1==nums[i]){
                c1++;
            } 
            else if(cand2 == nums[i]){
                c2++;
            }
            else if(c1==0){
                c1 = 1;
                cand1 = nums[i];
            } 
            else if(c2==0){
                c2 = 1;
                cand2 = nums[i];
            } else{
                c1--;
                c2--;
            }
        }
        int f1 =0 , f2=0; 
        for(int i=0; i<n;i++){
            if(nums[i] == cand1) f1++;
            else if(nums[i] == cand2 ) f2++;
        }
        if(f1>n/3) res.add(cand1);
        if(f2>n/3) res.add(cand2);
        return res;
    }
}
