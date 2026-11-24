// LC: CONSTRUCT BINARY TREE FROM PREORDER AND INORDER
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.*;

public class ConstructPreIn {
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
    int idx =0;
    HashMap<Integer, Integer> in = new HashMap<>();
    public TreeNode fun(int[] preorder, int low ,int high){
        if(low>high) return null;
        TreeNode n = new TreeNode(preorder[idx]);
        idx++;
        int id = in.get(n.val);
        n.left = fun(preorder, low, id-1);
        n.right = fun(preorder, id+1, high);
        return n;
    }
      public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0; i<inorder.length;i++) in.put(inorder[i], i);
        return fun(preorder, 0, inorder.length-1);
    }
}
