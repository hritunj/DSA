// LC: NEXT GREATER ELEMENT 1
// https://leetcode.com/problems/next-greater-element-i/
import java.util.*;;
public class NextGreater1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length , m = nums1.length;
        int[] res = new int[m];
        HashMap<Integer, Integer> f = new HashMap<>();
        for(int i=0; i<m;i++){
            f.put(nums1[i], i);
        }
        Stack<Integer> s = new Stack<>();
        s.add(nums2[n-1]);
        if(f.containsKey(nums2[n-1])) res[f.get(nums2[n-1])] = -1;
        for(int i= n-2 ; i>=0; i--){
            while(!s.isEmpty() && nums2[i] >=s.peek()){
                s.pop();
                continue;
            }
            if(s.isEmpty() ){
                if(f.containsKey(nums2[i])){
                    res[f.get(nums2[i])] = -1; 
                }
            }
            else{
                if(f.containsKey(nums2[i]))  res[f.get(nums2[i])] = s.peek();
            }
            s.push(nums2[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] n1 = {1,3,5,2,4};
        int[] n2 = {6,5,4,3,2,1,7};
        int[] res = nextGreaterElement(n1, n2);
        for(int i=0; i<res.length;i++) System.out.print(res[i] + " ");
    }
}
