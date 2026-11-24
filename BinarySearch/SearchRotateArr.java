// LEETCODE 33: SEARCH IN ROTATED SORTED ARR
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchRotateArr {
     public int search(int[] nums, int target) {
        int n= nums.length;
        int low= 0 , high = n-1;
        while(low<=high){
            int guess = (low+high)/2;
            if(nums[guess] > nums[n-1]){
                // part2: 3conditions: 
                if(nums[guess]==target) return guess;
                if(nums[guess] <target){
                    // right side is the only option
                    low = guess+1;
                    continue;
                }
                if(nums[guess] > target){
                    // two possibility 
                    if(target<nums[0]){
                        // right
                        low = guess+1;
                        continue;
                    } else{
                        // left
                        high = guess-1;
                        continue;
                    }
                }
            } else{
                // guess lies in part1
                if(nums[guess] == target) return guess;
                if(nums[guess] > target){
                    // we need lesser elements so go left
                    high = guess-1;
                    continue;
                }
                if(nums[guess] < target){
                    if(target>nums[n-1]){
                        high = guess-1;
                        continue;
                    } else{
                        // go right
                        low = guess+1;
                        continue;
                    }
                }
            }
        }
        return -1;
    }
}
