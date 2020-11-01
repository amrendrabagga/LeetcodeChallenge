package october.week5;

import java.util.Arrays;

public class Day2_NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxLen = 1;
        int n = nums.length;
        int length[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                    else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, length[i]);
        }
        // System.out.println(Arrays.toString(count));
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            if (length[i] == maxLen) {
                res += count[i];
            }
        }
        return res;
    }
}
