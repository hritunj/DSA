// LC: POW(X,N)
// https://leetcode.com/problems/powx-n/description/
public class PowXN {
     public double myPow(double x, int n) {
          if (b == 0)
            return 1;

        double half = pow(a, b / 2);
        double result = (half * half) % MOD;

        if (b % 2 == 1) {
            result = (result * a) % MOD;
        }
        
        return result;
        
    }
}
