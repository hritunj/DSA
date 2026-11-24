// GFG: Longest Substring with K Uniques
// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.
import java.util.*;
public class LongestKSubString {
    public int longestKSubstr(String s, int k) {
        int low =0, high=0 , res = Integer.MIN_VALUE , n = s.length();
        HashMap<Character, Integer> f = new HashMap<>(); // will store frequency of each character
        for(high =0; high<n;high++){
            char c = s.charAt(high);
            f.put(c, f.getOrDefault(c, 0)+1);
            while(f.size()>k){
                char cLow = s.charAt(low);
                f.put(cLow , f.get(cLow)-1);
                if(f.get(cLow)==0) f.remove(cLow);
                low++;
            }
            if(f.size()==k){
                int len = high-low+1;
                res = Math.max(len, res);
            }
        }
        return res==Integer.MIN_VALUE ? -1 : res;
    }
}
