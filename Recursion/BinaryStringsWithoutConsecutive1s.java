// TUF: GENERATE BINARY STRINGS WITHOUT CONSECUTIVE 1'S
// https://takeuforward.org/practice/dsa/generate-binary-strings-without-consecutive-1s

import java.util.*;

public class BinaryStringsWithoutConsecutive1s {
    static List<String> res = new ArrayList<>();
    public static void buildStrings(int n, int i, StringBuilder s, char prev){
        if(i==n){
            res.add(s.toString());
            return ;
        }
        if(prev=='1'){
            s.append('0');
            buildStrings(n, i+1, s, '0');
            s.deleteCharAt(s.length()-1);
            return ;
        }
        // choice 1: append 0
        s.append('0');
        buildStrings(n, i+1, s, '0');
        s.deleteCharAt(s.length()-1);
        //choice 2: append 1
        s.append('1');
        buildStrings(n, i+1, s, '1');
        s.deleteCharAt(s.length()-1);

    }
    public static List<String> generateBinaryStrings(int n) {
        buildStrings(n, 0, new StringBuilder(""), '2');
        return res;
    }
    
    public static void main(String[] args) {
        // generateBinaryStrings(3);
        count(3,0,'2');
        System.out.println(count(3, 0, '2'));
    }


    // Follow up question: Count subsequence without constructing string
    public static int count(int n, int i, char prev){
        if(i==n){
            return 1; 
        }
        if(prev=='1') return count(n, i+1, '0');
        return count(n, i+1, '0') + count(n, i+1, '1');
    }
}
