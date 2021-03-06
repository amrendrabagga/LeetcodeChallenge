package december.week3;

import java.util.HashMap;
import java.util.Map;

public class Day3_4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap();
        int n = A.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int sum = C[i] + D[j];
                count += map.getOrDefault(-sum, 0);
            }
        }
        return count;
    }
}
