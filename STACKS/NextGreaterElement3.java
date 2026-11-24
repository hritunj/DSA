// LC: NEXT GREATER ELEMENT III 
// https://leetcode.com/problems/next-greater-element-iii/

import java.util.Stack;

public class NextGreaterElement3 {
     public int nextGreaterElement(int n) {
        Stack<Integer> s = new Stack<>();
        while(n>0){
            int d = n%10;
            if(s.isEmpty()) s.push(d);
            while(!s.isEmpty() && s.peek()>d){
                int t = s.pop();
            }
        }
    }
}
