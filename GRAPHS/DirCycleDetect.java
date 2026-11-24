// GFG: DETECT CYCLE IN DIRECTED GRAPH
// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
import java.util.*;
public class DirCycleDetect {
    boolean[] visit; int[] path;
      public boolean isCyclic(int V, int[][] edges) {
        visit = new boolean[V]; 
        path = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i<V; i++) adj.add(new ArrayList<>());
        for(int i=0 ; i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        for(int i =0 ; i<V;i++){
            if(!visit[i] && dfs(adj, i)) return true;
        }
        return false;
    }
    boolean dfs(List<List<Integer>> adj , int node){
        visit[node] = true;
        path[node] = 1;
        for(int i=0 ;i <adj.get(node).size();i++){
            int neigh = adj.get(node).get(i);
            if(visit[neigh] == true && path[neigh] ==1) return true;
            if(!visit[neigh] && dfs(adj, neigh)) return true;
        }
        path[node] =0;
        return false;
    }
}
