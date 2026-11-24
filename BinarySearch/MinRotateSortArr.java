// LC 153: MIN IN ROTATED SORTED ARR
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class MinRotateSortArr {
    public int findMin(int[] nums) {
        int n = nums.length; int res = -1;
        int low = 0,high = n-1;
        while(low<=high){
            int guess = (low+high)/2;
            if(nums[guess] > nums[n-1]){
                // part 2
                low = guess+1;
            } else{
                // part1
                res = guess;
                high = guess-1;
            }
        }
        return res==-1 ? -1 : nums[res];
    }
}
