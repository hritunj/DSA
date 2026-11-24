// LC 767: REORGANIZE STRING
// https://leetcode.com/problems/reorganize-string/description/

import java.util.*;

public class ReorganiseString {
    class Pair {
        int f;
        char c;

        Pair(int first, char second) {
            f = first;
            c = second;
        }
    }
     public String reorganizeString(String s) {
        int[] f = new int[26];
        for(int i = 0; i< s.length(); i++) f[s.charAt(i) - 'a']++;
        PriorityQueue<Pair> m = new PriorityQueue<>(
            (a,b) -> {
                if(a.f!= b.f) return b.f - a.f;
                return b.c - a.c;
            }
        );
        for(int i = 0 ; i<26 ;i++){
            if(f[i] > 0) m.add(new Pair(f[i], (char)('a' + i)));
        }
        int seats = 0; StringBuilder res = new StringBuilder("");
        while(!m.isEmpty()){
            
            Pair p = m.poll();
            if(seats == 0 || res.charAt(seats -1 ) != p.c){
                res.append(p.c) ;
                p.f--;
                seats++;
                if(p.f>0) m.add(p);
            } else{
                if(m.isEmpty()) return "";
                Pair p2 = m.poll();
                res.append(p2.c);
                seats++;
                p2.f--;
                if(p2.f>0) m.add(p2);
                m.add(p);
            }
        }
        return res.toString();
    }
}
