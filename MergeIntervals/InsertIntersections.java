// LEETCODE 986 LIST INTERVAL INTERSECTION
// https://leetcode.com/problems/interval-list-intersections/
import java.util.*;
public class InsertIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j =0;
        while(i<firstList.length && j<secondList.length){
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            if(start1 < start2){
                if(end1 >=start2){
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1 , end2);
                    res.add(new int[]{s,e});
                }
            } else {
                // start2 <= start1
                if(end2 >=start1){
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1 , end2);
                    res.add(new int[]{s,e});
                }
            }
            if(end1 < end2){
                i++;
            } else{
                j++;
            }
        }
       
        if(res.size()==0) return new int[0][0];
        return res.toArray(new int[res.size()][]);
    }
}
