// LC 543: DIAMETER OF A TREE
// https://leetcode.com/problems/diameter-of-binary-tree/description/

public class Diameter {
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
    int res =0 ;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int left =diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int sum =left+right;
        res =Math.max(res, sum);
        return 1 + Math.max(right, left);
    }
}
