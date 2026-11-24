// LC 875 KOKO EATING BANANAS
// https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoBananas {
    long fun(int[] a, int guess){
        long h =0;
        int n = a.length;
        for(int i = 0;i<n;i++){
            if(a[i]%guess!=0){
                h = h+ a[i]/guess +1;
            } else{
                h= h+ a[i]/guess;
            }
        }
        return h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length; int max = Integer.MIN_VALUE; int res = -1;
        for(int i =0;i<n;i++) max = Math.max(max, piles[i]); // finding max of arr
        int low = 1,high = max;
        while(low<=high){
            int guess = (low+high)/2;
            long hour = fun(piles, guess);
            if(hour<h){
                // no: go right
                low = guess+1;
            } else{
                res = guess;
                high = guess-1;
            }
        }
        return res;
    }
}
