
// LEETCODE 56: MERGE INTERVALS
// https://leetcode.com/problems/merge-intervals/
import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> res = new ArrayList<>();
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];
            if (end1 >= start2) {
                start1 = Math.min(start1 , start2);
                end1 = Math.max(end2, end1);
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(start1);
            temp.add(end1);
            res.add(temp);
            start1 = start2;
            end1 = end2;
        }
        List<Integer> temp = new ArrayList<>();
            temp.add(start1);
            temp.add(end1);
            res.add(temp);
        return res.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

}