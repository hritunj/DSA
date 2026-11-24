// LEETCODE- 287 Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number/description/

public class DuplicateNumber {
     public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if(slow==fast){
                slow = 0;
                while(slow!=fast){
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
                
            }
        }
       
    }
}
