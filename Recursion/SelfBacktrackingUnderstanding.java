import java.util.*;
public class SelfBacktrackingUnderstanding { // subsets question
    public static void fun(int[] arr, ArrayList<Integer> temp, int i){
        if(i==arr.length){
            System.out.println(temp);
            return;
        }
        fun(arr, temp, i+1);
        temp.add(arr[i]);
        fun(arr, temp, i+1);
        temp.removeLast();
        return;
    }
    public static void main(String[] args) {
        ArrayList<Integer> t = new ArrayList<>();
        
        System.out.println(t);
        int[] ar = {1,2,3};
        fun(ar,t , 0);
    }
}
