// LEETCODE 74: SEARCH IN 2D MATRIX
// https://leetcode.com/problems/search-a-2d-matrix/description/
public class Search2D {
     public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0 , high = m*n-1;
        while(low<=high){
            int guess = low+ (high-low)/2;
            int curr = matrix[guess/n][guess%n];
            if(curr==target) return true;
            if(curr<target){
                // go right
                low = guess+1;
                continue;
            }
            if(curr>target){
                high = guess-1;
                continue;
            }
        }
        return false;
    }
}
