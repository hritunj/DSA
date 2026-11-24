// GFG: DETECT CYCLE IN UNDIRECTED GRAPH
// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
import java.util.*;
public class UndirCycleDetect {
    boolean[] visit;
     public boolean isCycle(int V, int[][] edges) {
        boolean b = false; visit = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++) adj.add(new ArrayList<>());
        for(int i =0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i =0 ; i<V;i++){
           if(!visit[i]){
             b = dfs(i, -1, adj);
           }
           if(b) return true;
        }
        return false;
    }
    boolean dfs(int node, int parent, List<List<Integer>> adj){
        boolean b = false;
        visit[node] = true;
        for(int i =0 ; i<adj.get(node).size();i++){
            int neigh = adj.get(node).get(i);
            if(visit[neigh] && neigh!=parent){
                return true;
            }
            if(!visit[neigh]){
               b= dfs(neigh, node, adj);
               if(b) return true;
            }
        }
        return false;
    }
}
