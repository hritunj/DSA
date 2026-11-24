// LC: TOP K FREQ WORDS
// https://leetcode.com/problems/top-k-frequent-words/

import java.util.*;

public class TopKFreqWords {
    class Pair {
        int f;
        String sec;

        Pair(int first, String second) {
            f = first;
            sec = second;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> f = new HashMap<>();
        PriorityQueue<Pair> m = new PriorityQueue<>((a, b) -> {
            if (a.f != b.f)
                return a.f - b.f;
            return b.sec.compareTo(a.sec);
        }); // min heap

        for (int i = 0; i < words.length; i++) {
            f.put(words[i], f.getOrDefault(words[i], 0) + 1);
        }

        for (Map.Entry<String, Integer> e : f.entrySet()) {
            Pair p = new Pair(e.getValue(), e.getKey());
            if (m.size() < k) {
                m.add(p);
            } else {
                if (m.peek().f < p.f) {
                    m.poll();
                    m.add(p);
                } else if (m.peek().f == p.f ) {
                    if( p.sec.compareTo(m.peek().sec) < 0){
                        m.poll();
                        m.add(p);
                    }
                } else {
                    continue;
                }
            }
        }
        while (!m.isEmpty()) {
            res.add(m.poll().sec);
        }
        Collections.reverse(res);
        return res; 

    }
}
