// TUF: N MEETINGS IN ONE ROOM
// https://takeuforward.org/practice/dsa/n-meetings-in-one-room

import java.util.Arrays;

public class NmeetingsInOneRoom {
    class Data {
        int start;
        int end;

        Data(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        Data[] a = new Data[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Data(start[i], end[i]);
        }
        Arrays.sort(a , (c,b)-> {
            if(c.end == b.end) return c.start - b.start;
            return c.end - b.end;
        });
        int res = 1;
        int prevEnd = a[0].end;
        for(int i=1; i<n;i++){
            if(a[i].start> prevEnd){
                res++;
                prevEnd = a[i].end;
            }
        }
        return res;
    }
}
