// LC: REOVER A BST
// https://leetcode.com/problems/recover-binary-search-tree/description/

public class RecoverBST {
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
    int wrong =0; 
    TreeNode w1first = null , w1second =null , w2first =null, w2second = null;
    TreeNode prev =null;
    void fun(TreeNode root){
        if(root==null) return;
        fun(root.left);
        if(prev==null){
            prev = root;
        } else{
            if(prev.val > root.val){
                if(wrong==0){
                    w1first = prev;
                    w1second = root;
                    wrong++;
                } else{
                    w2first = prev;
                    w2second  = root;
                    wrong++;
                }
            }
            prev = root;
        }
        fun(root.right);
    }
    public void recoverTree(TreeNode root) {
        
        fun(root);
        if(wrong==1){
            int t = w1first.val;
            w1first.val = w1second.val;
            w1second.val = t;
        } else{
             int t = w1first.val;
            w1first.val = w2second.val;
            w2second.val = t;
        }
    }   
}
