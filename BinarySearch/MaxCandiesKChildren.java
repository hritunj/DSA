// LC: MAX CANDIES TO K CHILDREN
// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
public class MaxCandiesKChildren{
    boolean fun(int[] candies , long k, long guess){
        if(guess==0) return true;
        long c=0 ;
        for(int i=0; i<candies.length;i++){
          if(guess!=0)  c+= candies[i]/guess;
        }
        return c>=k;
    }
    public int maximumCandies(int[] candies, long k) {
         int res = 0 , n = candies.length;
         int low =0 ;int high =0;
         for(int i=0; i<n;i++) high+= candies[i];
         if(high<k) return 0;
        while(low<=high){
            int guess = (low+high)/2;
            if(fun(candies, k, guess)){
                res =  guess;
                low = guess+1;
            } else{
                high = guess-1;
            }
        }
        return res;
    }
}