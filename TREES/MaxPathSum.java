// LC: BINARY TREE MAX PATH SUM
// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class MaxPathSum {
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
    public int fun(TreeNode root, int res){
        if(root==null) return 0;
        int left = Math.max(0,maxPathSum(root.left));
        int right = maxPathSum(root.right);
        int sum = left + right + root.val;
        res = Math.max(sum,res);
        return 1 + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        fun(root, res[0]);
        return res[0];


    }
}
