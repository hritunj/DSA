import java.util.*;

// import javax.swing.tree.TreeNode;
public class Traversals{
      class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }

    // LC: LEVEL ORDER 1: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int lvlsize = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<lvlsize;i++){
                TreeNode t = q.remove();
                temp.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            res.add(temp);
        }
        return res;
    }

    // ZIGZAG ORDER: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        int ok = 0;
        q.add(root);
        while(!q.isEmpty()){
            int lvlsize = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<lvlsize;i++){
                TreeNode t = q.remove();
                temp.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            if(ok%2!=0) {
                res.add(temp.reversed());
            } else{
                res.add(temp);
            }
            ok++;
        }
        return res;
    }


}


 