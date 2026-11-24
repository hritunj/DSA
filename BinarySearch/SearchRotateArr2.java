// LC: SEARCH IN ROTATED SORTED ARR 2
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class SearchRotateArr2 {
  public boolean search(int[] nums, int target) {
    int n = nums.length;
    int low = 0, high = n - 1;
    while (low<=high) {
      int mid = (low+high)/2; 
      if(nums[mid] == target) return true;
      if(nums[mid] == nums[low] && nums[high] == nums[mid]) {
        low++; high--;
      }
      else if (nums[low] <= nums[mid]){
        if(nums[low] <=target && target<nums[mid]) {
          high = mid-1; 
        } else{
          low = mid+1;
        }
      } 
      else{
        if(nums[high] >= target && nums[mid]<target){
          low = mid+1;
        } else{
          high = mid-1;
        }
      }
    }
    return false;
  }
}
