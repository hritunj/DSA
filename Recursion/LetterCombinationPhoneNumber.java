// LC 17: LETTER COMBINATION OF PHONE NUMBER
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.*;

public class LetterCombinationPhoneNumber {
    public String[] mapping = {"." , "," , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};
    public List<String> fun (String digits , int i , StringBuilder temp , ArrayList<String> res){
        if(i==digits.length()){
            res.add(temp.toString());
            return res;
        }
        char c = digits.charAt(i);
        String possibilities = mapping[c - '0'];
        for(int j = 0 ; j < possibilities.length();j++){
            temp.append(possibilities.charAt(j));
            fun(digits, i+1, temp, res);
            temp.deleteCharAt(temp.length()-1);
        }
        return res;
    }
      public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        return fun(digits, 0, temp, res);
    }
}
