// LC: K closest elements to x
// https://leetcode.com/problems/find-k-closest-elements/

import java.util.*;

public class KClosestElements {
    class Pair {
        int el;
        int diff;

        Pair(int e, int d) {
            el = e;
            diff = d;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.diff != b.diff)
                return Integer.compare(b.diff, a.diff);
            return Integer.compare(b.el, a.el);
        });
        for (int i = 0; i < k; i++) { // klogk
            Pair p = new Pair(arr[i], Math.abs(arr[i] - x));
            pq.add(p); // logk
        }
        for (int i = k; i < arr.length; i++) { // (n-k) (logk)
            Pair p = new Pair(arr[i], Math.abs(arr[i] - x));
            pq.add(p);
            pq.poll();
        }
        // answer
        while (!pq.isEmpty()) { // kn
            Pair p = pq.poll();
            res.addFirst(p.el);
        }
        Collections.sort(res);
        return res; // total = nlogk approx
    }
}
