// LEETCODE-75 Sort Colors
// https://leetcode.com/problems/sort-colors/description/
public class SortColors { 
    // explanation: https://www.youtube.com/watch?v=ljJJcYql6Bc
    // time: 17:45
     public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid =0;
        int high = n-1;
        while(mid<=high){
            if (nums[mid]==0){
                int t = nums[low];
                nums[low] = nums[mid];
                nums[mid] = t;
                mid++;
                low++;
            }
            else if (nums[mid] ==1){
                mid++;
            } 
            else{ // nums[mid] ==2
                int t= nums[high];
                nums[high] = nums[mid];
                nums[mid] = t;
                high--;
            }
        }
    }
}
