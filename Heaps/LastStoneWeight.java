// LC 1046: LAST STONE WEIGHT
// https://leetcode.com/problems/last-stone-weight/

import java.util.*;

public class LastStoneWeight {
      public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> m = new PriorityQueue<>(Collections.reverseOrder());
        int n = stones.length;
        for(int i =0 ; i< n ; i++) m.add(stones[i]);
        while(m.size()>=2){ // If the heap becomes empty (size == 0), then: true (we dont want this)
            int s1 = m.poll();
            int s2 = m.poll();
            if(s1==s2) continue;
            m.add(Math.abs(s1 - s2));
        }
        return m.isEmpty() ? 0 : m.peek();
    }
}
