
// LEETCODE- 977 SQAURES OF A SORTED ARRAY
// https://leetcode.com/problems/squares-of-a-sorted-array/description/?envType=problem-list-v2&envId=two-pointers
import java.util.*;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {

        ArrayList<Integer> neg = new ArrayList<>(); // will contain negative
        ArrayList<Integer> pos = new ArrayList<>(); // will contain positive

        // making negative and positive array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        // check if neg is 0
        if (neg.size() == 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }
        // check if pos is 0
        if (pos.size() == 0) {
            for (int i = 0; i < neg.size(); i++) {
                neg.set(i, neg.get(i) * neg.get(i));
            }
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();
        }

        // now neg is a sorted array and pos is a sorted array (not squared yet)
        // squre neg and pos
        for (int i = 0; i < neg.size(); i++) {
            neg.set(i, neg.get(i) * neg.get(i));
        }
        Collections.reverse(neg);
        for (int i = 0; i < pos.size(); i++) {
            pos.set(i, pos.get(i) * pos.get(i));
        }

        int i = 0;
        int j = 0;
        int idx = 0;
        int[] result = new int[pos.size() + neg.size()];

        while (i < pos.size() && j < neg.size()) {
            if (pos.get(i) < neg.get(j)) {
                result[idx] = pos.get(i);
                i++; idx++;
            } else {
                result[idx] = neg.get(j);
                j++; idx++;
            }
        }

        // if i exceeds bounds
        while (j < neg.size()) {
            result[idx] = neg.get(j);
            j++; idx++;
        }
        while (i < pos.size()) { // if j exceeds bounds
            result[idx] = pos.get(j);
            i++; idx++;
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
