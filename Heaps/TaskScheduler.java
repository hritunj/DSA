// LC 621: TASK SCHEDULER
// https://leetcode.com/problems/task-scheduler/description/

import java.util.*;

public class TaskScheduler {
    class Pair {
        int freq;
        char c;

        Pair(int f, char cc) {
            freq = f;
            c = cc;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int[] free = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
            free[tasks[i] - 'A'] = 1;
        }
        PriorityQueue<Pair> m = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq)
                        return b.freq - a.freq;
                    return b.c - a.c;
                });
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                m.offer(new Pair(freq[i], (char) ('A' + i)));
            }
        }
        int seat = 1;
        while (!m.isEmpty()) {
            ArrayList<Pair> temp = new ArrayList<>();

            while (!m.isEmpty()) {
                Pair p = m.poll();
                int f = p.freq;
                char c = p.c;
                if (free[c - 'A'] <= seat) {
                    if (f > 1) {
                        f--;
                        m.offer(new Pair(f, c));
                        free[c - 'A'] = seat + n + 1;
                    }
                    break;
                } else {
                    temp.add(p);

                }
            }
            for (int i = 0; i < temp.size(); i++) {
                m.offer(temp.get(i));
            }
            seat++;
        }
        return seat - 1;
    }
}
