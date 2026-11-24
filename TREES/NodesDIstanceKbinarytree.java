// LC: ALL NODES AT DISTANCE K IN BINARY TREE
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

import java.util.*;

public class NodesDIstanceKbinarytree {
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

    void makeParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parents = new HashMap<>();
        makeParents(root, parents);
        Map<TreeNode , Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int dis = 0;
        while (!q.isEmpty()) {
            if(dis==k) break;
            int size = q.size();
            dis++;
            for(int i=0; i<size;i++){
                TreeNode p = q.poll();
                if(p.left!=null && visited.get(p.left) == null){
                    q.offer(p.left);
                    visited.put(p.left, true);
                }
                if(p.right!=null && visited.get(p.right) == null){
                    q.offer(p.right);
                    visited.put(p.right, true);
                }
                if(parents.get(p) !=null && visited.get(parents.get(p)) == null){
                    q.offer(parents.get(p));
                    visited.put(parents.get(p), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll().val);
        }
        return res;
    }
}
