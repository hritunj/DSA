// LC: LCA OF BINARY TREE
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class LCAtree {
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

    TreeNode res = null;
    int fun(TreeNode root, TreeNode p ,  TreeNode q){ // gives number of people (p and q) this "root" is ancestor of
        if(root==null) return 0;
        int left = fun(root.left, p, q);
        int right = fun(root.right, p, q);
        int self = (root==p || root==q) ? 1 : 0;
        int total = left + right + self;
        if(total==2 && res==null){
            res= root;
        }
        return total;
    }
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        fun(root, p, q);
        return res;
    }
}
