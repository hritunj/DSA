// LC: SUM OF SUBARRAY RANGE
// https://leetcode.com/problems/sum-of-subarray-ranges/description/

import java.util.Stack;

public class SumOfSubarrayRange {
    public int[] nsl(int[] arr, Stack<Integer> s){
        int n = arr.length;
         int[] nsl = new int[n]; // arr containing idx of prev smaller (left)
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
        return nsl;
    }
    public int[] nsr(int[] arr, Stack<Integer> s){
        int n = arr.length;
        int[] nsr = new int[n]; // arr containing idx of next smaller (right)
        s.add(n-1); nsr[n-1] = n;
        for(int i=n-2; i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = -1; 
            } else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        return nsr;
    }
    public int[] ngr(int[] arr, Stack<Integer> s){
        int n = arr.length;
        int[] ngr = new int[n]; // arr containing idx of next greater (right)
        s.add(n-1); ngr[n-1] = n;
        for(int i=n-2; i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ngr[i] = -1; 
            } else{
                ngr[i] = s.peek();
            }
            s.push(i);
        }
        return ngr;
    }
    public int[] ngl(int[] arr, Stack<Integer> s){
        int n = arr.length;
        int[] ngl = new int[n]; // arr containing idx of prev greater (left)
        s.add(0); ngl[0] = -1;
        for(int i=0; i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ngl[i] = -1; 
            } else{
                ngl[i] = s.peek();
            }
            s.push(i);
        }
        return ngl;
    }
   
    public long subArrayRanges(int[] nums) {
        int n = nums.length; long res =0; 
        Stack<Integer> s = new Stack<>();
        int[] ngl = ngl(nums, s); 
        s.clear();
        int[] ngr = ngr(ngl, s);
        s.clear();
        int[] nsl = nsl(ngr, s); s.clear();
        int[] nsr = nsr(nsl, s); s.clear();
        for(int i=0; i<n;i++){
            
        }
    }
}
