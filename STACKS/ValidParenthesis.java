// LEETCODE 20 VALID PARANTHESIS
// https://leetcode.com/problems/valid-parentheses/description/
import java.util.*;
public class ValidParenthesis {
     public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ;i<s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(c=='(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if(c==')' && stack.peek()== '('){
                stack.pop();
                continue;
            }
            if(c==']' && stack.peek()== '['){
                stack.pop();
                continue;
            }
            if(c=='}' && stack.peek()== '{'){
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }
}
