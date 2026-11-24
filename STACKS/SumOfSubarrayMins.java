// LC: SUM OF SUBARRAY MINIMUMS
// https://leetcode.com/problems/sum-of-subarray-minimums/description/

import java.util.Stack;

public class SumOfSubarrayMins {
     public static  int sumSubarrayMins(int[] arr) {
        int n = arr.length; long res=0;
        int[] nsl = new int[n]; // arr containing idx of prev smaller (left)
        int[] nsr = new int[n]; // array containing idx of next smaller to right
        Stack<Integer> s = new Stack<>();
        s.add(0); nsl[0] = -1;
        for(int i=0; i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1; 
            } else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        s.clear(); // O(n)
        s.add(n-1); nsr[n-1] = n;
        for(int i=n-2; i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = n; 
            } else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        for(int i=0; i<n;i++){
            long left = i - nsl[i];
            long right = nsr[i] -i;
            res += (left*right)*arr[i];
        }
        return (int)(res % 1000000007);
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
}
