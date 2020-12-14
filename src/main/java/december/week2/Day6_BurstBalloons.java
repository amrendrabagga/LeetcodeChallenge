package december.week2;

import java.util.HashMap;
import java.util.Map;

public class Day6_BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int A[] = new int[n];
        A[0] = A[n-1] = 1;
        for (int i=0; i<nums.length; i++) {
            A[i+1] = nums[i];
        }
        return getCoin(A, 0, n-1);
    }

    Map<String, Integer> map = new HashMap<>();
    private int getCoin(int[] A, int l, int r) {
        String key = l + "|" + r;

        if (!map.containsKey(key)) {
            int maxCoin = 0;
            for (int i = l+1; i<r; i++) {
                int score = A[l] * A[i] * A[r];
                maxCoin = Math.max(maxCoin, score + getCoin(A, l, i) + getCoin(A, i, r));
            }
            map.put(key, maxCoin);
        }
        return map.get(key);
    }

    public static void main(String[] args) {
        Day6_BurstBalloons obj = new Day6_BurstBalloons();
        System.out.println(obj.maxCoins(new int[]{3,1,5,8}));
    }
}
