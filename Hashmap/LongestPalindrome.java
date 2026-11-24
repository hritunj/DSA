// LEETCODE 4-9: LONGEST PALINDROME
// https://leetcode.com/problems/longest-palindrome/description/

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
     public int longestPalindrome(String s) {
       HashMap<Character,Integer> f = new HashMap<>(); boolean odd = false; int res =0;
       for(int i = 0 ;i<s.length();i++) f.put(s.charAt(i), f.getOrDefault(s.charAt(i), 0)+1);
       for(Map.Entry<Character,Integer > e : f.entrySet()){
            int val = e.getValue();
            if(val%2==0){
                res+=val;
            } else{
                odd = true;
                res+= val-1;
            }
       }
       return odd? res+1 : res;
    }
}
