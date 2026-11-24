// LC: COUNT TOTAL NO OF NODES IN COMPLETE BINARY TREE
// https://leetcode.com/problems/count-complete-tree-nodes/description/

public class CountNodesCBT {
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
    
     public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        // return 1+left+right;
    } // it requires an optimal soln with less than O(n) (bit mask is req)
}
