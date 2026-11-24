// LC: COMPLETE BINARY TREE
// https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/

// import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
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

    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        boolean nullFound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t= q.poll();
            if(t==null){
                nullFound = true;
            } else{
                if(nullFound) return false;
                q.add(t.left);
                q.add(t.right);
            }
        }
        return true;
    }
}
