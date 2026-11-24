// TRIPLETS SUM SMALLER THAN TARGER (UNIQUE) 
// https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1

import java.util.*;

public class ThreeSumSmaller {
     public int countTriplets(int sum, int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;
        int count =0;

        for(int i =0;i<n;i++){
            int target = sum - arr[i];
            int left = i+1;
            int right = n-1;

            while(left<right){
                int summ = arr[left] + arr[right];
                if(summ<target){
                    count+= right-left;  // FOR EXPLANATION: https://www.youtube.com/watch?v=ljJJcYql6Bc
                    left++;
                    
                }
                else{
                    right--;
                }
            }
        }
        return count;
    }
}
