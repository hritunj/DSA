// AGGRESSIVE COWS: GFG
// https://www.geeksforgeeks.org/problems/aggressive-cows/1

import java.util.Arrays;

public class AggressiveCows {
    boolean check(int[] arr , int k , int guess){
        int cows  = 1;
        int pos = arr[0];
        for(int i =1 ;i<arr.length;i++){
            int dis = arr[i]  - pos;
            if(dis<guess){
                continue;
            }
            cows++;
            pos = arr[i];
        }
        return cows>=k;
    }
    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length; int low = 0 , high = arr[n-1] - arr[0]; int res=-1;
        while(low<=high){
            int guess =(low+high)/2;
            if(check(arr, k, guess)){
                // store and go right
                res = guess;
                low = guess+1;
            } else{
                // left
                high = guess-1;
            }
        }
        return res;
        
    }
}
