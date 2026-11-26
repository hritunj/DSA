// LC: NON OVERLAPPING INTERVALS
// https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

public class NonOverlappingIntervals {
     public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals , (a,b)->{
            if(a[1] == b[1]) return  Integer.compare(a[0], b[0]);
            return  Integer.compare(a[1], b[1]);
        });
        int res = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if(intervals[i][0] >= prevEnd){
                prevEnd = intervals[i][1];
            } else{
                res++;
            }
        }
        return res;
    }
}
