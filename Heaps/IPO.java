// LEETCODE: 502 IPO
// https://leetcode.com/problems/ipo/

import java.util.*;

public class IPO {
    class Pair {
        int c;
        int p;

        Pair(int cc, int pp) {
            c = cc;
            p = pp;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] proj = new Pair[n];
        for (int i = 0; i < n; i++) {
            proj[i] = new Pair(capital[i], profits[i]);
        }
        Arrays.sort(proj , (a,b) -> a.c - b.c);
        int idx = 0;
        PriorityQueue<Integer> m = new PriorityQueue<>(Collections.reverseOrder());
        while (k > 0) {
            while (idx < n) {
                if (proj[idx].c > w) {
                    break;
                }
                m.add(proj[idx].p);
                idx++;
            }
            if (m.isEmpty())
                return w;
            w += m.poll();
            k--;
        }
        return w;
    }
}
