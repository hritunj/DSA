// LC: COUNT GOOD NUMBERS
// https://leetcode.com/problems/count-good-numbers/
public class CountGoodNumbers {
    long MOD = 1_000_000_007L;

    long pow(long a, long b) {
        if (b == 0)
            return 1;

        long half = pow(a, b / 2);
        long result = (half * half) % MOD;

        if (b % 2 == 1) {
            result = (result * a) % MOD;
        }

        return result;
    }

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (pow(5, even) * pow(4, odd)) % MOD;

        return (int) ans;
    }

}
