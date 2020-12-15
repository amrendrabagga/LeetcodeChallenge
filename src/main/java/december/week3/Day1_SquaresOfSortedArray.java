package december.week3;

import java.util.Arrays;

public class Day1_SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int res[] = Arrays.stream(nums).boxed().sorted((a, b) -> Math.abs(a) - Math.abs(b))
                .mapToInt(i -> i).toArray();
        for (int i=0; i<nums.length; i++) {
            res[i] = res[i] * res[i];
        }
        return res;
    }

    public int[] sortedSquaresEfficient(int[] nums) {
        int n = nums.length-1;
        int[] res = new int[nums.length];

        int i = n, beg = 0, end = n;
        while (i >= 0) {
            if (nums[beg] * nums[beg] > nums[end] * nums[end]) {
                res[i--] = nums[beg] * nums[beg];
                beg++;
            }
            else {
                res[i--] = nums[end] * nums[end];
                end--;
            }
        }
        return res;
    }
}
