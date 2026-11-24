// LEADERS IN AN ARRAY
// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1   

import java.util.*;

public class LeadersInArray {
     static ArrayList<Integer> leaders(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        s.push(arr[n-1]);
        for(int i= n-2; i>=0;i--){
            if(arr[i]>=s.peek()) s.push(arr[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!s.isEmpty()){
            res.add(s.pop());
        }
        return res;
    }
}
