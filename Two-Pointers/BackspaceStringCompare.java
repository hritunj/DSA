// LEETCODE: 844 BACKSPACE STRING COMPARE
// https://leetcode.com/problems/backspace-string-compare/description/
import java.util.*;
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = n-1, j = m-1;
        int skip_s = 0 , skip_t = 0;
        while(i>=0 || j>=0){
           while(i>=0){
                if(s.charAt(i) == '#'){
                    skip_s++;
                    i--;
                } else if(skip_s > 0){
                    skip_s--;
                    i--; // basically ignored 
                } else{
                    break;
                }
           }
           while(j>=0){
                if(t.charAt(j) == '#'){
                    skip_t++;
                    j--;
                } else if(skip_t > 0){
                    skip_t--;
                    j--; // basically ignored 
                } else{
                    break;
                }
           }
        
        // now compare character
        char first = i<0 ? '%' : s.charAt(i);
        char second = j<0 ? '%' : t.charAt(j);
        if(first!=second) return false;
        i--;
        j--;
        }
        return true;
    }
}
