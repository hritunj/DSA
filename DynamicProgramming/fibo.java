// LC 509: FIBONACCI NUMBER
// https://leetcode.com/problems/fibonacci-number/

import java.util.HashMap;

public class fibo{
    HashMap<Integer,Integer> dp = new HashMap<>();
      public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp.containsKey(n)) return dp.get(n);
        int ans =  fib(n-1) + fib(n-2);
        dp.put(n, ans);
        return ans;
    }
}
