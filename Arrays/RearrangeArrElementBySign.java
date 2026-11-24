// LC: REARRANGE ARRAY ELEMENTS BY SIGN
// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

public class RearrangeArrElementBySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int ne = 1 ;
        int p= 0;
        for(int i=0 ;i<n;i++){
            if(nums[i]>=0){
                res[p] = nums[i];
                p+=2;
            } else{
                res[ne] = nums[i];
                ne+=2;
            }
        }
        return res;

    }
}
