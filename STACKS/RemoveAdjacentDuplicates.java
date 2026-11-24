// LEETCODE 1047 REMOVE ALL ADJACENT DUPLICATES
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
import java.util.*;
public class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = 0 ;i<n; i++){
            if(st.empty()){
                st.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i)==st.peek()){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        while(!st.empty()){
            res.append(st.pop());
        }
        res.reverse();
        return res.toString();
    }
}
