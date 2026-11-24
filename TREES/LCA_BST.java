// KC 235: LCA OF BST
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

public class LCA_BST {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root == p || root == q)
            return root;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            } else if (curr.val > p.val && curr.val > q.val) {
               curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }
}
