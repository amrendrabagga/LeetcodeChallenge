package november.week1;

import java.util.Arrays;

public class Day6_SmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        if (nums == null || nums.length == 0)
            return -1;
        int high = Arrays.stream(nums).max().orElse(1);
        int low = 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int res = calculateResult(nums, mid);
            if (res == threshold)
                return mid;
            else if (res > threshold)
                low = low + 1;
            else
                high = mid - 1;
        }

        return nums.length;
    }

    private int calculateResult(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            res += Math.ceil((num / (double)mid));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(10/(double)3));
        Day6_SmallestDivisorGivenThreshold obj = new Day6_SmallestDivisorGivenThreshold();
        System.out.println(obj.smallestDivisor(new int[]{2,3,5,7,11}, 11));
    }
}
