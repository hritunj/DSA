// LC 200: NO OF ISLANDS
// https://leetcode.com/problems/number-of-islands/description/
import java.util.*;
public class NoOfIslands { // in LC SOLUTION: No visited array needed: Mark each visited land cell directly as '0' in the grid, using the grid itself to track visited cells. 
// JUST TO MAKE IT MORE OPTIMAL 
    List<List<Boolean>> visit = new ArrayList<>();
    int[] x = {-1, 1,0,0};
    int[] y = {0,0,-1,1};
    boolean valid(char[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if((i<0 || i>=n) || (j<0 || j>=m)){
            return false;
        }
        return true;
    }
    void dfs(char[][] grid, int i, int j){
        visit.get(i).set(j, true);
        for(int k =0 ;k<4;k++){
            int row= i + x[k];
            int col = j + y[k];
            if(valid(grid, row, col) && visit.get(row).get(col) == false && grid[row][col] == '1'){
                dfs(grid, row, col);
            }
        }
    }
     public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i =0 ; i < n;i++){
           visit.set(i, new ArrayList<>());
           for(int j=0; j<m;j++){
            visit.get(i).set(j, false);
           }
        }
        int res =0;
        for(int i =0; i<n;i++){
            for(int j =0; j<m;j++){
                if(grid[i][j] == '1' && !visit.get(i).get(j)){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
}
