// LC: MAX WIDTH OF BINARY TREE
// https://leetcode.com/problems/maximum-width-of-binary-tree/

import java.util.*;

public class MaxWidthBT {
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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode n , int l){
            node = n;
            level = l;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        int res = 0;
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int len = q.size();
            int minn = q.peek().node.val;
            int first = 0 , last =0;
            for(int i=0; i<len;i++){
                Pair p = q.poll();
                int curr_id = p.level- minn;
                if(i==0) first = curr_id;
                if(i==len-1) last = curr_id;
                if(p.node.left!=null) q.offer(new Pair(p.node.left, curr_id*2+1));
                if(p.node.right!=null) q.offer(new Pair(p.node.right, curr_id*2+2));
            }
            res = Math.max(res, last-first+1);
        }
        return res;
    }
}
