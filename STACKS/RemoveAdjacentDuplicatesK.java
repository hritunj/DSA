// REMOVE ADJACENT DUPLICATES IN K (LEETCODE: 1209)
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/

import java.util.*;

public class RemoveAdjacentDuplicatesK {
    public record Pair<K, V>(K key , V value){}
     public String removeDuplicates(String s, int k) {
        int n = s.length(); 
        Stack<Pair<Character,Integer>> st = new Stack<>();
        for(int i = 0 ;i<n ; i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                st.push(new Pair<Character,Integer>(c, 1));
                continue;
            }
            if(st.peek().key!=c){
                st.push(new Pair<Character,Integer>(c, 1));
                continue;
            } 
            if(st.peek().value() < k -1){
                int t = st.peek().value();
                st.pop();
                st.push(new Pair<Character,Integer>(c, t+1));
                continue;
            }
            st.pop();
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            Pair<Character, Integer> p = st.pop();
            int v = p.value;
            while(v>0){
                res.append(p.key());
                v--;
            }
        }
        return res.reverse().toString();
    }   
}
