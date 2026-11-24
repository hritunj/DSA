// LEETCODE 724: FIND PIVOT INDEX (idx where prefix sum == suffix sum)
//  https://leetcode.com/problems/find-pivot-index/description/
public class FindPivotIndex {
      public int pivotIndex(int[] nums) {
        int prefix = 0;
        int sum = 0; 
        int suffix ;
        for(int i =0 ; i<nums.length;i++) sum += nums[i];
        for(int i =0; i<nums.length ; i++){
            if(i==0){
                prefix = 0;
            } else{
                prefix += nums[i-1];
            }
            suffix = sum - prefix - nums[i];
            if(prefix == suffix) return i;
        }
        
        return -1;
    }
}
