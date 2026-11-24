// LC: COUNT SET BITS
// https://leetcode.com/problems/number-of-1-bits/
public class CountSetBits {
     public int hammingWeight(int n) {
        int res=0;
        while(n>0){
            res++;
             n = n & (n-1);
        }
        return res;
    } 
}
