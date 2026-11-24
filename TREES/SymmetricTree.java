// LC 101: SYMMETRIC TREE
// https://leetcode.com/problems/symmetric-tree/


public class SymmetricTree {
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

    public boolean fun(TreeNode p , TreeNode q){
         if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return p.val == q.val && (fun(p.left, q.right) && fun(p.right, q.left) );
    }
     public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        return fun(p, q);
    }
}
