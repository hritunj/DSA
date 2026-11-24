// GFG: CHECK SORTED ARR 
// https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1

import java.util.ArrayList;

public class SortedArr {
    // public static boolean isSorted(int[] arr , int i) {
    //     if(arr.length == 0 || arr.length == 1) return true;
    //     if(i==arr.length-1) return true;
    //     return arr[i] < arr[i+1] && isSorted(arr, i+1);
        
    // }

    // SUM OF DIGITS: 
    // public static int sum(int n , int sum){
    //     if(n==0) return sum;
    //     return sum(n/10, sum + n%10);
    // }


    // REMOVE ALL OCCURANCES OF A CHARACTER:

    // public static String fun(String s, int i , String res , char c){
    //     if(s.length()==0 || i==s.length()-1) return res;
    //     StringBuilder r = new StringBuilder("");
    //     if(s.charAt(i) != c){
    //         r.append(s.charAt(i));
    //     }
    //     return fun(s, i+1, r.toString(), c);


    // }

    //print all possible paths you can take: you have 2 doors, each door: can go left or right (random ques for fun , ignore)
    public static void fun(String[] doors, ArrayList<String> t , int i){
        if(i==doors.length) {
            System.out.println(t);
            return;
        }
        t.add("left");
        fun(doors, t, i+1);
        // t.removeLast();
        t.remove("left");
        t.add("right");
        fun(doors, t, i+1);
        t.remove("right");
        return;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,300,40};
        // System.out.println(sum(22222, 0));
        String s = "hello";
        // System.out.println(fun(s, 0, null, 'l'));
        ArrayList<String> t = new ArrayList<>();
        fun(new String[]{"D1 " , "D2"}, t , 0);
        System.out.println("-------------------------------");
        System.out.println(t);
    }
}
