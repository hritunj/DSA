// LC: SINGLE ELEMENT IN SORTED ARRAY
// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class SingleElementSortedArray {
     public static  int singleNonDuplicate(int[] nums) {
       int n = nums.length , low =0 , high = n-1;
       if(n<2) return nums[0];
       if(n%2==0) return -1;
       while(low<=high){
            int guess = low + (high-low)/2;
            if(guess==0 || guess==n-1) return nums[guess];
            if(nums[guess] > nums[guess-1] && nums[guess] < nums[guess+1]){
                return nums[guess];
            }
            if(nums[guess] == nums[guess-1] ){
                if(guess%2!=0) {
                    low = guess+1;
                }
                else{
                    high = guess-1;
                }
            }
            if(nums[guess] == nums[guess+1]){
                if(guess%2==0) {
                    low = guess+1;
                }
                else{
                    high = guess-1;
                }
            }
       }
       return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        System.out.println(singleNonDuplicate(nums));
    }
}
