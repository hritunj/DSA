// LC 215: KTH LARGEST
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.*;

public class KthLargest {
     public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> m = new PriorityQueue<>();
        for(int i = 0; i<k ;i++) m.add(nums[i]);
        for(int i = k ;i<nums.length; i++){
            if(nums[i] > m.peek()){
                m.poll();
                m.add(nums[i]);
            }
        }
        return m.peek();
    }
}
