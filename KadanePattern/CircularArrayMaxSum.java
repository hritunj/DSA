public class CircularArrayMaxSum {
    public int maxSubarraySumCircular(int[] nums) {
        String s = "fuckme";
        Character.isAlphabetic(s.charAt(0));
        Character.isLetterOrDigit(s.charAt(0));
        int minend = nums[0];
        int maxend = nums[0];
        int sum = nums[0];
        int maxres = nums[0];
        int minres = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minend = Math.min(minend + nums[i], nums[i]);
            maxend = Math.max(maxend + nums[i], nums[i]);
            sum += nums[i];
            maxres = Math.max(maxend, maxres);
            minres = Math.min(minend, minres);
        }
        if (maxres < 0)
            return maxres;
        return Math.max(maxres, sum - minres);
    }
}
