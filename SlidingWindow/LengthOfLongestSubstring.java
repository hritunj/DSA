// LEETCODE 3:  Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
import java.util.*;
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int low =0, high =0, n = s.length() , res = 0;
        HashMap<Character,Integer> f = new HashMap<>();
        for(high =0 ; high<n ; high++){
            f.put(s.charAt(high), f.getOrDefault(s.charAt(high), 0) +1);
            int k = high -low+1; //length of window
            while(f.size()<k){
                f.put(s.charAt(low), f.get(s.charAt(low))-1);
                if(f.get(s.charAt(low))==0) f.remove(s.charAt(low));
                low++;
                k = high -low+1; // we have to update k as well since low is getting updated
            }
            int len = high -low+1;
            res = Math.max(res, len);
        }
        return res;
    }
}
