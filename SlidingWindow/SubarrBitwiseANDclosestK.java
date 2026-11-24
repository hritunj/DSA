// https://www.geeksforgeeks.org/dsa/bitwise-and-of-sub-array-closest-to-k/
public class SubarrBitwiseANDclosestK {
    static int[] freq = new int[32];

    public static void updatefreq(int val, int ref) {
        int i=0;
        while(val>0){
            if((val&1)==1){ // if rightmost bit is 1
                freq[i] += ref; // if ref == -1 then it will be removed, if ref==1 then included
            }
            val /=2; // or val>>1
            i++;
        }   
    }

    public static int minimumDifference(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length, AND = nums[j], res = Integer.MAX_VALUE;
        while (j < n) {
            AND &= nums[j];
            updatefreq(nums[j], 1); // 1 means including nums[j] to AND
            res = Math.min(Math.abs(AND - k), res);
            while (i <= j && AND < k) {
                updatefreq(nums[i], -1); // -1 means removing nums[j] from AND
                i++;
                AND = 0;
                for (int b = 0; b < 32; b++) {
                    if (j - i + 1 == freq[b])
                        AND = AND | (1 << b);
                }
                res = Math.min(Math.abs(AND - k), res);
            }
            if (k == AND)
                return 0;
            j++;

        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr= {816, 5006, 838, 321, 1190, 6874, 7082, 6819, 6651}; int k =97; // fails for this case , expected = 31
        System.out.println(minimumDifference(arr, k));
    }
}
