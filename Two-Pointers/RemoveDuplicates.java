// LEETCODE-26 Remove Duplicates from Sorted Array
//  https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=problem-list-v2&envId=two-pointers
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int[] expectedNums = new int[nums.length];
        int i=1; // Traversal
        int k = 1; // number of unique elements : return 
        int j =0; // index of last unique element in result array
        while(i<nums.length){
            if(nums[i]==nums[i-1]){
                i++; continue;
            }
            j++; k++; i++;
            expectedNums[j] = nums[i];
        }
        return k;
    }
    public static void main(String[] args) {
        
    }
}
