import java.util.*;
// LC 778: SWIM IN RISING WATER
// https://leetcode.com/problems/swim-in-rising-water/description/

public class SwimRisingWater { // there are two approaches: binary search and dijkstra 
    class Pair{ // dijkstra done: now do binary search
        int money;
        int row;
        int col;
        Pair(int m, int r, int c){
            money = m;
            row = r;
            col= c;
        }
    }
    public boolean valid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public int swimInWater(int[][] grid) {
        // dijkstra:
        int n = grid.length , m = grid[0].length;
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.money-b.money);
        int[][] res = new int[n][m];
        for(int i=0; i<n;i++){
            Arrays.fill(res[i], 100000000);
        }
        pq.add(new Pair(grid[0][0], 0, 0));
        res[0][0] = grid[0][0];
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int mon = p.money;
            int row = p.row;
            int col = p.col;
            if(mon>res[row][col]) continue;
            for(int k=0; k<4;k++){
                int r = row+x[k];
                int c = col + y[k];
                if(!valid(r, c, n, m)) continue;
                int newmoney = Math.max(mon, grid[r][c]);
                if(newmoney<res[r][c]){
                    res[r][c] = newmoney;
                    pq.add(new Pair(newmoney, r, c));
                }
            }
        }
        return res[n-1][m-1];
    }
}
