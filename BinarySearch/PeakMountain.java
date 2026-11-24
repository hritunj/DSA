// LEETCODE 852: PEAK MOUNTAIN INDEX
// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakMountain {
     public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length; int low = 0 ,high = n-1; int res = -1;
        while(low<=high){
            int guess = (low+high)/2;
            if(arr[guess] < arr[guess+1]){
                // increasing part
                low = guess+1;
            } else{
                // decreasing part
                res = guess;
                high = guess-1;
            }
            
        }
        return res;
    }
}
