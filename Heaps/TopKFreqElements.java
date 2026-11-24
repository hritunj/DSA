// LC : TOP K FREQ ELEMENTS
// https://leetcode.com/problems/top-k-frequent-elements/description/
import java.util.*;
public class TopKFreqElements {
    static class Pair{
        int f;
        int sec;
        Pair(int first, int second){
            f = first;
            sec = second;
        }
    }
     public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> f = new HashMap<>();
        PriorityQueue<Pair> m = new PriorityQueue<>((a,b) ->{
            if(a.f != b.f) return a.f - b.f;
            return a.sec - b.sec;
        }); //min heap
        for(int i = 0 ; i<nums.length;i++){
            f.put(nums[i], f.getOrDefault(nums[i], 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> e: f.entrySet()){
            Pair p = new Pair(e.getValue(), e.getKey());
            if(m.size()<k){
                m.add(p);
            } else{
                if(m.peek().f< p.f){
                    m.poll();
                    m.add(p);
                } 
               
            }
        }
        for(int i = 0 ;i<k;i++){
            res[i] = m.poll().sec;
        }
       
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,2,4,1,2,3,3,1,3,3,4};
        int[] res = topKFrequent(nums, 2);
        for(int i=0; i<res.length;i++) System.out.print(res[i] + " ");

    }
}
