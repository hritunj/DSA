// LC: REMOVE K DIGITS
// https://leetcode.com/problems/remove-k-digits/

// import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (res.length() > 0 && res.charAt(res.length() - 1) > c && k > 0) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            if(res.length()==0 && c=='0'){ // we dont need leading zeroes in result
                continue;
            } else{
                res.append(c);
            }
        }
        // dealing the case where num = "1234" like this. So, deleting k characters from last
        while(res.length()>0&& k>0){
            res.deleteCharAt(res.length()-1);
            k--;
        }
        
        return res.length()==0 ? "0" : res.toString();
    }
}
