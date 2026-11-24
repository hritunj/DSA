// LC 104: MAX DEPTH OF BINARY TREE
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

public class MaxDepth {
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

    
}
