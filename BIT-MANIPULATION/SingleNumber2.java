// LC: SINGLE NUMBER 2
// https://leetcode.com/problems/single-number-ii/

// import java.util.*;
public class SingleNumber2 {
     public int singleNumber(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=1;i<nums.length; i+=3){
        //     if(nums[i]!=nums[i-1]) return nums[i-1];
        // }
        // return nums[nums.length-1];

        int ones = 0;
        int twos= 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            ones = (ones^nums[i]) & ~ones;
            twos = (twos^nums[i]) & ~twos;
        }
        return ones;
    }
}
