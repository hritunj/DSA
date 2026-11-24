// GFG: ALLOCATE MIN PAGES
// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1


public class AllocateMinPages {
    boolean check(int[] arr , int k , long guess){
        int kids = 1;
        long prevPage = arr[0];
        for(int i = 1; i<arr.length;i++){
           if(prevPage+arr[i] <= guess){
                prevPage += arr[i];
                continue;
           }
           kids++;
           prevPage = arr[i];
           if(k<kids) return false;
        }
        return k>=kids;
    }
     public int findPages(int[] arr, int k) {
        int n = arr.length;
        if(n<k) return -1;
        long low = arr[0] , high =0; long res =-1;
        for(int i = 0 ; i<n;i++) {
            high+= arr[i];
            if(arr[i] > low) low = arr[i];
        }
        while(low<=high){
           long guess = low + (high - low) / 2;
            if(check(arr, k, guess)){
                res = guess;
                high = guess-1;
                continue;
            } else{
                low = guess+1;
            }
        }
        return (int) res;
    }
}
