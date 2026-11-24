// LC 127: WORD LADDER
// https://leetcode.com/problems/word-ladder/

import java.util.*;

public class WordLadder {
    class Pair{
        String s;
        int i;
        Pair(String s, int i){
            this.s = s;
            this.i = i;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> f = new HashMap<>();
        for(int i=0;i<wordList.size(); i++){
            String el = wordList.get(i);
            f.put(el, f.getOrDefault(el, 0)+1);
        }
        if(!f.containsKey(endWord)) return 0;
        Queue<Pair> q = new ArrayDeque<>(); q.add(new Pair(beginWord, 1)); 
        f.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.poll();
            int v = p.i;
            StringBuilder s = new StringBuilder(p.s);
            if(endWord.contentEquals(s)) {
                return v;
            }
            for(int i=0; i<s.length();i++){
                char c= s.charAt(i);
                for(int j= 97; j<=122;j++){
                    if(c==j) continue;
                    s.setCharAt(i, (char) j);
                    String next = s.toString();
                    if(f.containsKey(next)) {
                        q.add(new Pair(next, v+1));
                        f.remove(next);
                    }
                }
                s.setCharAt(i, c);
            }
        }
        return 0;
    }
}
