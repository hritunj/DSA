// LEETCODE-202 HAPPY NUMBER
// https://leetcode.com/problems/happy-number/description/
public class HappyNumber {

    public int fun(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += (d * d);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (fast != 1) {
            slow = fun(slow);
            fast = fun(fast);
            fast = fun(fast);
            if (fast == slow && slow != 1) {
                return false;
            }
        }
        return true;

    }
}