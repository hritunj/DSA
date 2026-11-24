// LC 70: CLIMBING STAIRS
// https://leetcode.com/problems/climbing-stairs/description/

import java.util.HashMap;

public class ClimbingStairs {
    HashMap<Integer, Integer> f = new HashMap<>();
     public int climbStairs(int n) {
        return fun(0,n);
    }
    int fun(int i,int n){
        if(i==n) return 1;
        if(i>n) return 0;
        if(f.containsKey(i)) return f.get(i);
        int ans = fun(i+1, n) + fun(i+2, n);
        f.put(i, ans);
        return ans;
     }
}
