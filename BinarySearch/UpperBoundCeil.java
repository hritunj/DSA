// Ceil in a Sorted Array
// https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1

public class UpperBoundCeil {
    public static int findCeil(int[] arr, int x) {
        int n = arr.length;
        int res = Integer.MAX_VALUE;
        int low = 0 ,high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] >= x){
                // desired condition
                res = Math.min(res, mid); // since array is sorted we can do this, lower the index, lower the coresponding value
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return res==Integer.MAX_VALUE ? -1:res;
        
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 8, 10, 11, 12, 19};
        System.out.println(findCeil(arr, 0));
    }
}

