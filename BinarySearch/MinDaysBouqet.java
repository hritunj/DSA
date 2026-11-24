// LC 1482: MIN DAYS TO MAKE M BOUQUETS
// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinDaysBouqet {
    boolean helper(int[] bloomDay, int m, int k, int guess) {
        int n = bloomDay.length;
        int b = 0, l = 0;
        int i = 0;
        while (i < n) {
            if (bloomDay[i] <= guess) {
                l++;
                if (l == k) {
                    b++;
                    l = 0;
                }
                i++;
            } else{
                l=0;
                i++;
            }
        }
        return b >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] < low)
                low = bloomDay[i];
            if (bloomDay[i] > high)
                high = bloomDay[i];
        }
        while (low <= high) {
            int guess = low + (high - low) / 2;
            if (helper(bloomDay, m, k, guess)) {
                res = guess;
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }
        return res;
    }
}
