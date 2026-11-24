// GFG: MINIMUM SPANNING TREE
// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
import java.util.*;;
public class MinSpanningTree {
    class Pair{
        int wt;
        int node;
        Pair(int w,int n){
            wt = w;
            node = n;
        }
    }
     public int spanningTree(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        boolean[] visit = new boolean[V]; int sum=0;
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.wt-b.wt);
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int w = p.wt;
            int n = p.node;
            if(visit[n]) continue;
            visit[n] = true; sum+=w;
            for(int i=0;i<adj.get(n).size();i++){
                int neigh = adj.get(n).get(i).node;
                int wt = adj.get(n).get(i).wt;
                if(!visit[neigh]){
                    pq.add(new Pair(wt, neigh));
                }
            }
        }
        return sum;
    }
}
