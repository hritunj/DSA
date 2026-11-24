// TOPOLOGICAL SORT: GFG
// https://www.geeksforgeeks.org/problems/topological-sort/1

import java.util.*;

public class TopologicalSort {
      public ArrayList<Integer> topoSort(int V, int[][] edges) {
        int[] indeg = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i<V;i++) adj.add(new ArrayList<>());
        for(int i=0 ; i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q =new ArrayDeque<>();
        ArrayList<Integer> res =new ArrayList<>();
        for(int i =0 ; i<V;i++) if(indeg[i] ==0) q.add(i);
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int i =0; i<adj.get(node).size();i++){
                int neigh = adj.get(node).get(i);
                if(--indeg[neigh] ==0){
                    q.add(neigh);
                }

            }
        }
        return res;
    }
}
