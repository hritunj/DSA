// GFG: KTH SMALLEST
// https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

import java.util.*;

public class KthSmallest {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> m = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ;i< k;i++) m.add(arr[i]);
        for(int i = k ; i<arr.length;i++){
            if(m.peek()>arr[i]){
                m.poll();
                m.add(arr[i]);
            }
        }
        return m.peek();
        
    }
}
