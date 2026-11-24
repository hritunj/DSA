// LEETCODE 74: FIND FIRST AND LAST POS
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FirstLastIndex {
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;int[] res = {-1,-1};
        int low= 0,high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<target){
                low = mid+1;
                continue;
            }
            if(nums[mid]>target){
                high = mid-1;
                continue;
            }
            // nums[mid] == target
            res[0] = mid;
            high = mid-1;
        }
        low =0 ; high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<target){
                low = mid+1;
                continue;
            }
            if(nums[mid]>target){
                high = mid-1;
                continue;
            }
            // nums[mid] == target
            res[1] = mid;
            low = mid+1;
        }
        return res;
    }
     public static void main(String[] args) {
        int[] arr = {1, 1, 2, 8, 10, 11, 12, 19};
        System.out.println(searchRange(arr, 2));
    }
}
