// LC 22: GENERATE PARENTHESIS
// https://leetcode.com/problems/generate-parentheses/description/

import java.util.*;

public class GenerateParenthesis {
    static List<String> fun(int open, int close, int n, StringBuilder temp, List<String> res) {
        if (open == n && close == n) {
            res.add(temp.toString());
            return res;
        }
        // first choice : open
        if (open < n) {
            temp.append("(");
            fun(open + 1, close, n, temp, res);
            temp.deleteCharAt(temp.length() - 1);

        }
        // for close
        if (close < open) {
            temp.append(")");
            fun(open, close + 1, n, temp, res);
            temp.deleteCharAt(temp.length() - 1); 

        }
        return res;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        return fun(0, 0, n, new StringBuilder(""), res);

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
