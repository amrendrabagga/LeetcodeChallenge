package december.week3;

import java.util.Arrays;

public class Day7_SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length - 1;
        int max = A[n] - K;
        int min = A[0] + K;
        int res = A[n] - A[0];
        for (int i=0; i<n; i++) {
            int new_max = Math.max(max, A[i] + K);
            int new_min = Math.min(min, A[i+1] - K);
            res = Math.min(res, new_max - new_min);
        }
        return res;
    }
}
