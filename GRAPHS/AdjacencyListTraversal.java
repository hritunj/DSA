// ADJACENCY LIST TRAVERSAL: GFG
//https://www.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1

import java.util.*;

public class AdjacencyListTraversal {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> res =new ArrayList<>();
        // initialising: 
        for(int i=0;i<V;i++){
            res.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            res.get(u).add(v);
            res.get(v).add(u);
        }
        return res;
        
    }
}
