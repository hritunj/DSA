// GFG : BFS OF GRAPH
// https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

import java.util.*;

public class BFS {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q =new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int i =0 ;i<adj.get(node).size();i++){
                int n = adj.get(node).get(i);
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
        return res;
        
    }
}
