// GFG: BELLMAN FORD ALFGORITHM
// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

import java.util.*;

public class BellmanFord {
     public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
       ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(V, 100000000 )); // gfg expects this instead of Integer.MAX_VALUE
       res.set(src, 0);
        for(int i=0;i<V-1; i++){
            for(int j=0; j<edges.length;j++){
                int s = edges[j][0];
                int d = edges[j][1];
                int wt = edges[j][2];
                if(res.get(s)!=100000000  && res.get(d) > res.get(s) + wt){
                    res.set(d, res.get(s) +wt);
                }
            }
        }
         for(int j=0; j<edges.length;j++){
                int s = edges[j][0];
                int d = edges[j][1];
                int wt = edges[j][2];
                if(res.get(s)!=100000000  && res.get(d) > res.get(s) + wt){
                    return new ArrayList<>(Collections.nCopies(1, -1));
                }
            }
        return res;
    }
}
