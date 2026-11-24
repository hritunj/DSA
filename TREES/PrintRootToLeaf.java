// TYF: PRINT ALL ROOT TO LEAF PATHS
// https://takeuforward.org/practice/dsa/print-root-to-leaf-path-in-bt

import java.util.*;

public class PrintRootToLeaf {
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

      TreeNode(int val) { data = val; left = null; right = null; }
    }
    void fun(TreeNode node, List<Integer> temp , List<List<Integer>> res){
        if(node == null) return ;
        temp.add(node.data);
        if(node.left!=null) {
            fun(node.left, temp, res);
            temp.removeLast();
        }
        if(node.right!=null){
            fun(node.right, temp, res);
            temp.removeLast();
        }
        if(node.right==null && node.left==null) res.add(new ArrayList<>(temp));
    }
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        fun(root, temp, res);
        return res;
    }
}
