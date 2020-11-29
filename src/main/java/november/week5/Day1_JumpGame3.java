package november.week5;

import java.util.HashMap;
import java.util.Map;

public class Day1_JumpGame3 {
    Map<Integer, Boolean> map = new HashMap();
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length)
            return false;
        if (map.containsKey(start))
            return map.get(start);
        if (arr[start] == 0) {
            map.put(start, true);
            return true;
        }
        map.put(start, false);
        return canReach(arr, start - arr[start]) || canReach(arr, start + arr[start]);
    }
}
