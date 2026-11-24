// LEETCODE 383: RANSOME NOTE
// https://leetcode.com/problems/ransom-note/description/

import java.util.HashMap;

public class Ransomenote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // HashMap<Character,Integer> ran_f = new HashMap<>();
        // HashMap<Character,Integer> mag_f = new HashMap<>();
        // for(int i= 0 ;i< magazine.length();i++) mag_f.put(magazine.charAt(i), mag_f.getOrDefault(magazine.charAt(i), 0)+1);
        
        // for(int i = 0 ;i<ransomNote.length();i++){
        //     ran_f.put(ransomNote.charAt(i), ran_f.getOrDefault(ransomNote.charAt(i), 0)+1);
        //     if(!mag_f.containsKey(ransomNote.charAt(i))) return false;
        //     if(ran_f.get(ransomNote.charAt(i)) > mag_f.get(ransomNote.charAt(i))) return false;
        // }
        // return true;


        // ANOTHER ARRAY APPROACH: (FASTER)
        int[] f = new int[26]; // // f[i] stores the count of ('a' + i)
        for(int i = 0 ; i< magazine.length();i++){
            f[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i<ransomNote.length();i++){
            if(--f[ransomNote.charAt(i) - 'a'] < 0 ) return false; // one character used , so subtract 1 from freq array 
        }
        return true;
        
    }
}
