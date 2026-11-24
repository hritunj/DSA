// LC 743: NETWORK DELAY TIME
// https://leetcode.com/problems/network-delay-time/description/
import java.util.*;

public class NetworkDelayTime {
    class Pair {
        int node;
        int wt;

        Pair(int n, int w) {
            node = n;
            wt = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n];
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            time[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u-1).add(new Pair(v-1, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.wt-b.wt);
        time[k] =0; pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int w = p.wt;
            int node = p.node;
            if(w>time[node]) continue;
            for(int i=0;i<adj.get(node).size();i++){
                int neigh = adj.get(node).get(i).node;
                int wt = adj.get(node).get(i).wt;
                if(w+wt < time[neigh]){
                    time[neigh] = w+wt;
                    pq.add(new Pair(neigh, wt + w));
                }
            }
        } int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(time[i] == Integer.MAX_VALUE) return -1;
            if(time[i]>res) res = time[i];
        }
        return res;
    }
}
