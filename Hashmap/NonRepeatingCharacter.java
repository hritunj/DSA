// LEETCODE 387: FIRST NON REPEAT CHARACTER 
// https://leetcode.com/problems/first-unique-character-in-a-string/description/

import java.util.HashMap;

public class NonRepeatingCharacter {
      public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> f = new HashMap<>();
        for(int i =0;i<n; i++) f.put(s.charAt(i), f.getOrDefault(s.charAt(i), 0)+1); // calculates freq of each character

        for(int i =0; i<n; i++){
            if(f.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
