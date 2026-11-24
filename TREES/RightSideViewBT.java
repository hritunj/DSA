// LC: BINARY TREE RIGHT SIDE VIEW
// https://leetcode.com/problems/binary-tree-right-side-view/description/

import java.util.*;

public class RightSideViewBT {
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
    void fun(TreeNode root, List<Integer> res , int lvl){
        if(root==null) return ;
        if(lvl == res.size()) res.add(root.val);
        fun(root.right, res, lvl+1);
        fun(root.left, res, lvl+1);
    }
     public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        fun(root, res, 0);
        return res;
        
    }
}
