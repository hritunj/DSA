// LC: SEARCH INSERT POSITION
// https://leetcode.com/problems/search-insert-position/
public class SearchInsert {
     public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low =0 ,high = n-1;
        while (low<=high) {
            int guess = low + (high-low)/2;
            if(nums[guess] ==target) return guess;
            if(nums[guess] > target){
                high = guess-1;
            } else{
                low = guess+1;
            }
        }
        return low;
    }
}
