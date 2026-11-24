// LEETCODE 378: KTH SMALLEST ELEMENT
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
public class KSmallest2D {
    int helper(int[][] matrix , int guess){
        int n = matrix.length , m = matrix[0].length; int row = n-1 , col=0;
        int count = 0;
        while(row>=0&&col<m){
            int e = matrix[row][col];
            if(e<=guess){
                count = count + row+1;
                col++;
            } else{
                row--;
            }
        }
        return count;
    }
     public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length , m = matrix[0].length; 
        int low = matrix[0][0] , high = matrix[n-1][m-1];
        int res = -1;
        while(low<=high){
            int guess = low + (high-low)/2;
            int ans = helper(matrix, guess);
            if(ans<k){
                low = guess+1;
            } else{
                res = guess;
                high = guess-1;
            }
        }
        return res;
    }
}
