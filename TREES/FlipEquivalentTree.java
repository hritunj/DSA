// LC: FLIP EQUIVALENT TREE
// https://leetcode.com/problems/flip-equivalent-binary-trees/description/


public class FlipEquivalentTree {
    public class TreeNode {
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return fun(root1, root2);
    }
}
