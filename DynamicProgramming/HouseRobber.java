// LC: HOUSE ROBBER
// https://leetcode.com/problems/house-robber/description/

import java.util.Arrays;

public class HouseRobber {
    int[][] arr; 
    int fun(int[] nums, int i , int free){
        if(i==nums.length) {
            return 0; 
        }
        if(arr[i][free] != -1) {
            return arr[i][free];
        }
        if(free==0) {
            return arr[i][free]= fun(nums, i+1, 1);
        }
        int c1 = nums[i] + fun(nums, i+1, 0);
        int c2 = fun(nums, i+1, 1);
        return arr[i][free] =  Math.max(c1, c2);
    }
    public int rob(int[] nums) {
        arr = new int[nums.length][2]; 
        for(int i=0 ; i<nums.length;i++){
            Arrays.fill(arr[i], -1);
        }
        return fun(nums, 0, 1);
    }
}
