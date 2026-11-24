// LC: PALINDROME PARITIONING 
// https://leetcode.com/problems/palindrome-partitioning/

import java.util.*;

public class PalindromePartioning {
    void fun(String s, int ind, List<String> temp, List<List<String>> res) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(temp));
            return ;
        }
        for(int i= ind; i<s.length();i++){
            if(isPalindrome(s, ind,i)){
                String sub = s.substring(ind, i+1);
                temp.add(sub);
                fun(s, i+1, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
    boolean isPalindrome(String s,int i, int j){
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j++)) return false;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        fun(s, 0, temp, res);
        return res;
    }
}
