
// SHORTEST PATH IN UNWEIGHTED GRAPH
// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
import java.util.*;;

public class ShortestDistUnweighted {
    class Fun {
        int node;
        int dist;

        Fun(int n, int d) {
            node = n;
            dist = d;
        }
    }

    public int shortestPath(int V, int[][] edges, int src, int dest) {
        if (src == dest)
            return 0;
        boolean[] visit = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Fun> q = new ArrayDeque<>();
        q.add(new Fun(src, 0));
        visit[src] = true;
        while (!q.isEmpty()) {
            Fun f = q.poll();
            int d = f.dist;
            int n = f.node;
            if(n==dest) return d;
            for (int i = 0; i < adj.get(n).size(); i++) {
                int neigh = adj.get(n).get(i);
                if(!visit[neigh]){
                    visit[neigh] = true;
                    q.add(new Fun(neigh, d+1));
                }
            }
        }
        return -1;

    }
}
