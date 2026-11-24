// TUF: MIN TIME TO BURN A BT
// https://takeuforward.org/practice/dsa/minimum-time-taken-to-burn-the-bt-from-a-given-node

import java.util.*;

public class MInTimeToBurnBT {
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    
    void makeParent(TreeNode root, Map<TreeNode ,TreeNode> parents){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parents.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    TreeNode findNode(TreeNode root , int target){
        Queue<TreeNode> q = new LinkedList<>();
        if(root.data == target) return root;
        q.offer(root);
        while (!q.isEmpty()) {
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode n = q.poll();
                if(n.data==target) return n;
                if(n.left!=null) {
                    q.offer(n.left);
                }
                if(n.right!=null){
                    q.offer(n.right);
                }
            }
        }
        return null;
    }

    public int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode , TreeNode> parents = new HashMap<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        makeParent(root, parents);
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode target = findNode(root, start);
        q.offer(target);
        visited.put(target, true);
        int time =0;
        while (!q.isEmpty()) {
            boolean burned = false;
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode n = q.poll();
                if(n.left!=null && visited.get(n.left)==null){
                    q.offer(n.left);
                    visited.put(n.left, true);
                    burned = true;
                }
                if(n.right!=null && visited.get(n.right)==null){
                    q.offer(n.right);
                    visited.put(n.right, true);
                    burned = true;
                }
                if(parents.get(n)!=null && visited.get(parents.get(n)) ==null ){
                    q.offer(parents.get(n));
                    visited.put(parents.get(n), true);
                    burned = true; 
                }
            }
            if(burned) time++;
            
        }
        return time;
        
    }
}
