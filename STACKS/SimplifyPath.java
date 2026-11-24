
// LC: SIMPLIFY PATH
// https://leetcode.com/problems/simplify-path/
import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        int n = path.length();
        Stack<String> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = path.charAt(i);
            if (c == '/')
                continue;
            StringBuilder temp = new StringBuilder();
            while (i < n && path.charAt(i) != '/') {
                temp.append(path.charAt(i));
                i++;
            }
            if ("..".contentEquals(temp)) {
                if (!s.isEmpty())
                    s.pop();
                continue;
            } else if (".".contentEquals(temp)) {
                continue;
            } else {
                s.push(temp.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        if(s.isEmpty()) return "/";
        for (String str : s) {
            res.append("/");
            res.append(str);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path));
    }
}
