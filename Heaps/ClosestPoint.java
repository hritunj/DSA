// LC: 973 K CLOSEST POINTS TO ORIGIN
// https://leetcode.com/problems/k-closest-points-to-origin/description/
import java.util.*;
public class ClosestPoint {
    class Pair{
        int dist;
        int idx;
        Pair( int i){
            idx = i;
        }
        int dist(int[] point ){
            return (int) (Math.pow(point[0] , 2) + Math.pow(point[1], 2)) ; // root dist comparing: no need of root
        }
    }
     public int[][] kClosest(int[][] points, int k) {
        int[][] res  = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) ->{
               if(a.dist!=b.dist) return b.dist - a.dist;
               return b.idx - a.idx;
            });
        for(int i = 0 ;i<k;i++){
             int[] point = points[i];
            Pair p = new Pair(i);
            p.dist = p.dist(point);
            pq.add(p);
        }
        for(int i = k ; i<points.length;i++){
            int[] point = points[i];
            Pair p = new Pair(i);
            p.dist = p.dist(point);
            pq.add(p);
            pq.poll();
        }
        for(int i = 0 ; i<k;i++){
            Pair p = pq.poll();
            int id = p.idx;
            res[i] = points[id] ;
        }
        return res;
    }
}
