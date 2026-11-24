// LEETCODE 503: NEXT GREATER ELEMENT 2
// https://leetcode.com/problems/next-greater-element-ii/
import java.util.*;        
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
          int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i = n-2; i>=0; i--){
            st.push(nums[i]);
        }
        for(int i = n -1; i>=0;i--){
            while(!st.isEmpty() && nums[i] >= st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            } else{
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }
}
