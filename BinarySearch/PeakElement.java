// LC: FIND PEAK ELEMENT 
// https://leetcode.com/problems/find-peak-element/description/
public class PeakElement {
    public static  int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0 , high = n-1;
        if(n==1 ) return n-1;

        while(low<=high){
            int guess = low + (high-low)/2;

            if(guess==0){
                if(nums[guess] > nums[guess+1]) return guess;
                low = guess+1;
                continue;
            }
            if(guess==n-1){
                if(nums[guess] > nums[guess-1]) return guess;
                high = guess-1;
                continue;
            }

            if(nums[guess] > nums[guess-1] && nums[guess]>nums[guess+1]) return guess;
            if(nums[guess] < nums[guess-1]){
                high = guess-1; continue;
            }
            if(nums[guess] < nums[guess+1]){
                low = guess+1; continue;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(findPeakElement(nums));
    }
}
