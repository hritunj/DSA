// LC PATH SUM
// https://leetcode.com/problems/path-sum/description/

import java.util.*;

public class PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            res += root.val;
            return res == targetSum;
        }
        res += root.val;
        int temp = res;
        boolean b1 = hasPathSum(root.left, targetSum);
        if (b1)
            return true;
        res = temp;
        boolean b2 = hasPathSum(root.right, targetSum);
        if (b2)
            return true;
        return false;
    }

    // LC: PATH SUM II
    // https://leetcode.com/problems/path-sum-ii/
    List<List<Integer>> result = new ArrayList<>();

    public void fun(TreeNode root, int targetSum, List<Integer> temp, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += root.val;
            temp.add(root.val);
            if (sum == targetSum) {
                result.add(new ArrayList<>(temp));

            }
            return;
        }
        sum += root.val;
        int t = sum;
        temp.add(root.val);
        if (root.left != null) {
            fun(root.left, targetSum, temp, sum);
            temp.removeLast();
            sum = t;
        }
        if (root.right != null) {
            fun(root.right, targetSum, temp, sum);
            temp.removeLast();
            sum = t;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp = new ArrayList<>();
        fun(root, targetSum, temp, 0);
        return result;
    }
}
