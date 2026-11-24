// GFG: DIJKSTRA ALGORITHM
// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
import java.util.*;

public class DijkstraAlgo {
    class Pair{
        int node; 
        int wt;
        Pair(int n, int w){
            node = n;
            wt = w;
        }
    }
     public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<Integer> res = new ArrayList<>();
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>()); 
            res.add(Integer.MAX_VALUE);
        }
        for(int i=0; i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.wt - b.wt);
        res.set(src, 0);
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int d = p.wt;
            int n = p.node;
            if(d>res.get(n)) continue;
            for(int i=0;i<adj.get(n).size();i++){
                int neigh = adj.get(n).get(i).node;
                int wt = adj.get(n).get(i).wt;
                if(d+wt<res.get(neigh)){
                    res.set(neigh, d+wt);
                    pq.add(new Pair(neigh, d+wt));
                }

            }
        }
       return res;

    }
}
