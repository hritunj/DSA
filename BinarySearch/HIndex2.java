// LC 275: H INDEX II
// https://leetcode.com/problems/h-index-ii/
public class HIndex2 {
    boolean fun(int[] citations , int guess){
         int c=0;
        for (int i : citations) {
            if(guess<=i) c++;
        }
        return c>=guess;
    }
     public int hIndex(int[] citations) {
        int n = citations.length;           // O(nlogn) tc
        // int low =0 , high =n; int res = 0; 
        // while(low<=high){
        //     int guess = low + (high-low)/2;
        //     if(fun(citations, guess)){
        //         res = guess;
        //         low = guess+1;
        //     } else{
        //         high= guess-1;
        //     }
        // }
        // return res;


        // OPTIMISED APPROACH: O(logn ) tc
        int low =0 , high = n-1; 
        while(low<=high){
            int guess = low + (high-low)/2;
            int papers = n-guess;
            if(citations[guess] >=papers){
                high = guess-1;
            } else{
                low = guess+1;
            }
        }
        return n-low;
    }
}
