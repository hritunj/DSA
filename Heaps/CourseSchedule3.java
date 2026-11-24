// LC: COURSE SCHEDULE 3
// https://leetcode.com/problems/course-schedule-iii/description/

import java.util.*;

public class CourseSchedule3 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses , (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1] );
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // to contain durations
        int time =0;
        for(int[] c : courses){
            if(c[0] <= c[1]){
                if(c[0] + time <= c[1]){ // can we take this course?
                    heap.offer(c[0]);
                    time += c[0];
                } else{ // can we make space for this course by removing longest course?
                    if(heap.peek()>c[0]){
                        time -= heap.poll(); // swap with longest course
                        time += c[0];
                        heap.offer(c[0]);
                    }
                }
            }
        }
        return heap.size();
    }
}
