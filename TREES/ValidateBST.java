// LC 98: VALIDATE BST
// https://leetcode.com/problems/validate-binary-search-tree/description/


public class ValidateBST {
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

    boolean ans = true; TreeNode prev =null; // https://www.youtube.com/watch?v=5PrzZfhk1OQ
    void fun(TreeNode root){
        if(root==null) return;
        fun(root.left);
        if(prev==null){
            prev = root;
        } else{
            if(root.val<= prev.val) {
                ans=false;
                prev = root;
            }
        }
        fun(root.right);
    }
     public boolean isValidBST(TreeNode root) {
        fun(root);
        return ans;
    }
}
