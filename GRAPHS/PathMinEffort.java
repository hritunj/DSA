// LC 1631: PATH WITH MINIMUM EFFORT
//https://leetcode.com/problems/path-with-minimum-effort/description/

import java.util.*;;

public class PathMinEffort {
    class Pair {
        int dis;
        int row;
        int col;

        Pair(int d, int r, int c) {
            dis = d;
            row = r;
            col = c;
        }
    }

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(res[i], Integer.MAX_VALUE);
        int[] x = { 1, -1, 0, 0 };
        int[] y = { 0, 0, 1, -1 };
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        res[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int d = p.dis;
            int r = p.row;
            int c = p.col;
            if (r == n - 1 && c == m - 1)
                return d;
            if (d > res[r][c])
                continue; // old value
            for (int k = 0; k < 4; k++) {
                int row = r + x[k];
                int col = c + y[k];
                if (!isValid(row, col, n, m))
                    continue;
                int absDiff = Math.abs(heights[row][col] - heights[r][c]);
                int max = Math.max(absDiff, d);
                if (max < res[row][col]) {
                    res[row][col] = max;
                    pq.add(new Pair(max, row, col));
                }

            }
        }
        return res[n - 1][m - 1];
    }
}
