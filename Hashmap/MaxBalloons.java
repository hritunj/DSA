// LEETCODE 1189 MAX BALLOONS
// https://leetcode.com/problems/maximum-number-of-balloons/description/

import java.util.HashMap;
import java.util.Map;

public class MaxBalloons {
      public int maxNumberOfBalloons(String text) {
        int res = Integer.MAX_VALUE;
        HashMap<Character, Integer> f1 = new HashMap<>(); // stores for balloon
        HashMap<Character,Integer> f2 = new HashMap<>(); // stores for text
        f1.put('b', 1);
        f1.put('a', 1);
        f1.put('l', 2);
        f1.put('o', 2);
        f1.put('n', 1);
        for(int i = 0 ; i<text.length(); i++) f2.put(text.charAt(i) , f2.getOrDefault(text.charAt(i), 0) +1);
        for(Map.Entry<Character,Integer> c : f1.entrySet()){
            int fhave = f2.getOrDefault(c.getKey(), 0); 
            int fneed = c.getValue();
            int times = fhave/fneed; // number of times we can make balloons
            res = Math.min(times, res);
        }
        return res;
        
       
    }
}
