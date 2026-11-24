// LC 4: MEIDAN OF TWO SORTED ARRAYS
// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianSortedArrays {
    double fun(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int left = (m + n + 1) / 2;
        int low = 0, high = m;
        
        while (low <= high) {
            int guess = low + (high - low) / 2; // guess is Px
            int x1 = Integer.MIN_VALUE, x2 = Integer.MIN_VALUE, x3 = Integer.MAX_VALUE, x4 = Integer.MAX_VALUE;
            if (guess > 0)
                x1 = a[guess - 1];
            if ((left - guess) > 0)
                x2 = b[(left - guess) - 1];
            if (guess >= 0 && guess < m)
                x3 = a[guess];
            if ((left - guess) >= 0 && (left - guess) < n)
                x4 = b[(left - guess)];

            if (x1 <= x4 && x2 <= x3) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
                } else {
                    return (double) (Math.max(x1, x2));
                }
            }
            if (x1 > x4) {
                high = guess - 1;
            }
            if (x2 > x3) {
                low = guess + 1;
            }
        }
        return Integer.MIN_VALUE;

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n < m) {
            return fun(nums1, nums2);
        }
        return fun(nums2, nums1);
    }
}
