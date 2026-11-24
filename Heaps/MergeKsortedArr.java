// GFG: MERGE K SORTED ARRAYS
// https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

import java.util.*;

public class MergeKsortedArr {
    class Pair {
        int value;
        int row;
        int col;

        Pair(int v, int r, int c) {
            value = v;
            row = r;
            col = c;
        }
    }

    public ArrayList<Integer> mergeArrays(int[][] mat) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.value, b.value));
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(mat[i][0], i, 0));
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int v = p.value , r = p.row , c = p.col;
            res.add(v);
            if(c<(m-1)){
                pq.offer(new Pair(mat[r][c+1], r, c+1));
            }
        }
        return res;
    }
}
