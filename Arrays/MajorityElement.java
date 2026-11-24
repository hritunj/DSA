// LC: MAJORITY ELEMENT 1
// https://leetcode.com/problems/majority-element/description/

public class MajorityElement {
     public int majorityElement(int[] nums) {
        // BOYER-MOORE ALGORITHM
        int n = nums.length , candidate = nums[0] , count=1;
        for(int i=1; i<n;i++){
            if(nums[i] == candidate){
                count++;
            } else{
                if(count==0){
                    candidate = nums[i]; count =1;
                } else{
                    count--;
                }
            }
        }
        return candidate;
    }
}