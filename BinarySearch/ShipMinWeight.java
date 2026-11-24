// LC 1011: Capacity To Ship Packages Within D Days
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class ShipMinWeight {
    boolean helper(int[] weights , int days, int guess){ // guess is max allowed weight
        int n = weights.length;
        int currWeight = weights[0]; int time = 1;

        for(int i = 1 ; i< n;i++){
            if(currWeight + weights[i] <= guess){
                currWeight += weights[i];
                continue;
            } else{
                time++;
                currWeight = weights[i];
            }
        }
        return time<=days;
    }
     public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;  int low = Integer.MIN_VALUE , high = 0; int res = -1;
        for(int i =0 ; i<n;i++){
            high += weights[i];
            if(weights[i]>low) low = weights[i];
        }
        while(low<=high){
            int guess = low + (high-low)/2;
            if(helper(weights, days, guess)){
                res = guess;
                high = guess-1; 
            } else{
                low = guess+1;
            }
        }
        return res;
    }
}
