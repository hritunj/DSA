// LC: VERTICAL ORDER TRAVERSAL OF A BINARY TREE
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.*;

public class VerticalOrderTraversalBT {
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
        int row;
        int col;
        Pair(TreeNode n , int r, int c){
            node = n;
            row = r;
            col = c;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode n = p.node;
            int x = p.row;
            int y = p.col;
            if(n.left!=null) q.offer(new Pair(n.left, x-1, y+1));
            if(n.right!=null) q.offer(new Pair(n.right, x+1, y+1));
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(n.val);
        }
        List<List<Integer>> res= new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> n: ys.values()){
                while(!n.isEmpty()){
                    res.get(res.size()-1).add(n.poll());
                }
            }
        }
        return res;
    }
}
