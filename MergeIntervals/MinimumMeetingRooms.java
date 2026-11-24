// MEETING ROOMS 2: GFG
// https://www.geeksforgeeks.org/problems/attend-all-meetings-ii/1

import java.util.Arrays;

public class MinimumMeetingRooms {
    public int minMeetingRooms(int[] start, int[] end) {
        int res = 0; int room = 0; 
        int i = 0 , j = 0 ;
        Arrays.sort(start);
        Arrays.sort(end);
        while(i<start.length && j <end.length){
            if(start[i] < end[j]){
                room++;
                res = Math.max(res, room);
                i++;
            } else{
                room--;
                j++;
            }
        }
        return res; 
    }
}
