// LEETCODE 1186: MAX SUM WITH ONE DELETION
// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/description/
public class MaxSumOneDeletion {
    public int maximumSum(int[] arr) {
        int nodelete = arr[0];
        int res= arr[0];
        int onedelete = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int prevnodelete = nodelete;
            int prevonedelete = onedelete;
            nodelete = Math.max(arr[i], arr[i] + prevnodelete);
            int v;
            if (prevonedelete == Integer.MIN_VALUE) {
                v = arr[i];
            } else {
                v = prevonedelete + arr[i];
            }
            onedelete = Math.max(prevnodelete, v);
            res = Math.max(onedelete, Math.max(nodelete, res));
        }
        return res;
    }
}
