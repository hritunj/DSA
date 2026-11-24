// TYF: COUNT ALL SUBSEQUENCES WITH SUM K 
// https://takeuforward.org/practice/dsa/count-all-subsequences-with-sum-k
public class CountallSubsequencesSumK {
    int count =0;
    public void fun(int[] nums, int k, int i , int sum){
        if(i==nums.length){
            if(sum==k) count+=1;
            return;
        }
        // don't choose
        fun(nums, k, i+1, sum);
        // choose:
        if(sum + nums[i] <=k){
            sum+= nums[i];
            fun(nums, k, i+1, sum);
            sum-=nums[i];
        }
        // return count;
    }
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
         fun(nums, k, 0, 0);
         return count;
    }
}
