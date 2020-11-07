package november.week1;

import java.util.Arrays;

public class Day6_SmallestDivisorGivenThreshold {

    private int calculateResult(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            res += Math.ceil((num / (double) mid));
        }
        return res;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        if (nums == null || nums.length == 0)
            return -1;
        int high = Arrays.stream(nums).max().orElse(1);
        int low = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int t = calculateResult(nums, mid);
            if (t > threshold)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}