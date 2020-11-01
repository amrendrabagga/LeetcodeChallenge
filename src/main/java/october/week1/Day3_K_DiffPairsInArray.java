package october.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day3_K_DiffPairsInArray {

    public int findPairsEfficient(int[] nums, int k) {
        Set<Integer> set = new HashSet();
        Set<Integer> higherValue = new HashSet();

        for (int n : nums) {
            if (set.contains(n-k))
                higherValue.add(n);
            if (set.contains(n+k))
                higherValue.add(n+k);
            set.add(n);
        }
        return higherValue.size();
    }

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        for (int n : map.keySet()) {
            if (k == 0) {
                if (map.get(n) >= 2) res++;
            }
            else if (map.containsKey(n+k)) {
                res++;
            }
        }
        return res;
    }
}
