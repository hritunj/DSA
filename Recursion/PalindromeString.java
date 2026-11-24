// GFG: PALINDROME STRING
// https://www.geeksforgeeks.org/problems/palindrome-string0817/1
public class PalindromeString {
     public  static boolean isPalindrome(String s , int i) {
        if(s.length()==0) return true;
        if(i==-1) return true;
        return s.charAt(i) == s.charAt(s.length()-1-i) && isPalindrome(s, i-1);
        
    }
    public static void main(String[] args) {
        String s = "eye ";
        System.out.println(isPalindrome(s.trim(), 0));
    }
}
