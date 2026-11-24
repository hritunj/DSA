// LC: 240 SEARCH 2D II
// https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class Search2DII {
     public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; int m = matrix[0].length;
        int row = n-1 , col = 0;
        while(row>=0 && col<m){
            if(matrix[row][col] == target ) return true;
            if(matrix[row][col] > target){
                row--;
                continue;
            }
            if(matrix[row][col] < target){
                col++;
                continue;
            }
        }
        return false;
    }
}
