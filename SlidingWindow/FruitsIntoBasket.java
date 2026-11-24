// LEETCODE: 
// https://leetcode.com/problems/fruit-into-baskets/
import java.util.*;
public class FruitsIntoBasket {
     public int totalFruit(int[] fruits) {
        int low =0 , high =0, n = fruits.length , res = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for ( high = 0; high < fruits.length; high++) {
            freq.put(fruits[high],freq.getOrDefault(fruits[high], 0)+1 );
            while(freq.size()>2){
                 freq.put(fruits[low],freq.get(fruits[low])-1 );
                 if(freq.get(fruits[low]) ==0) freq.remove(fruits[low]);
                 low++;
            }
            int len = high -low+1;
            res = Math.max(res, len);
        }   
        return res;
    }
}
