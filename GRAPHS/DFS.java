// DFS OF GRAPH: GFG
// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

import java.util.*;

public class DFS {
    List<Boolean> visit = new ArrayList<>();
    ArrayList<Integer> res = new ArrayList<>();
    void fun(int node , ArrayList<ArrayList<Integer>> adj){
        res.add(node);
        visit.set(node , true) ;
        for(int i =0 ; i<adj.get(node).size();i++){
            int n = adj.get(node).get(i);
            if(!visit.get(n)){
            fun(n, adj);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0 ; i<adj.size();i++) visit.add(false);
        fun(0, adj);
        return res;
    }
}
