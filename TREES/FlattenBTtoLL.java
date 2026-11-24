// LC: FLATTEN BINARY TREE TO LINKED LIST
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

import java.util.*;

public class FlattenBTtoLL {
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
    
    void getPreOrder(TreeNode root , List<TreeNode> preorder){
        if(root==null) return ;
        preorder.add(root);
        getPreOrder(root.left, preorder);
        getPreOrder(root.right, preorder);
    }
    public void flatten(TreeNode root) {
        if(root==null) return ;
        List<TreeNode> preorder = new ArrayList<>();
        getPreOrder(root, preorder);
        TreeNode curr = preorder.get(0);
            curr.left = null;
            curr.right = null;
        for(int i=1; i<preorder.size();i++){
            TreeNode n = preorder.get(i);
            n.left = null;
            n.right = null;
            curr.right = n;
            curr = n;
        }
    }
}
