// GFG: TOP VIEW OF BINARY TREE
// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

import java.util.*;

public class TopViewBT {
    class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
    class Pair{
        Node node;
        int line;
        Pair(Node n, int l){
            node = n;
            line = l;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res= new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> m = new TreeMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node n = p.node;
            int l = p.line;
           if(n.left!=null) q.add(new Pair(n.left, l-1));
           if(n.right!=null)  q.add(new Pair(n.right, l+1));
            if(!m.containsKey(l)){
                m.put(l, n.data);
            }
        }

         for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
        
    }
}
