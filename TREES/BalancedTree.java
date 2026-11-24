// LC: BALANCED BINARY TREE
// https://leetcode.com/problems/balanced-binary-tree/description/



public class BalancedTree {
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
     
     public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(Math.abs(left-right) >1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
