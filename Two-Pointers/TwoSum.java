// LEETCODE- 167-Two Sum II - Input Array Is Sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=problem-list-v2&envId=two-pointers

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        
        int i=0; int j = numbers.length-1;

        while(i<j){
            
            if(numbers[i]+ numbers[j]==target) {
                return new int[] {i+1, j+1};
            }
            if(numbers[i] + numbers[j] > target){
                j--;
            }
            if(numbers[i]+numbers[j] < target){
                i++;
            }
        }
          return new int[] {0,0};
    }
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
    }
}
