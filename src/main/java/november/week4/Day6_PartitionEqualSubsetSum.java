package november.week4;

import java.util.HashMap;
import java.util.Map;

public class Day6_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0)
            return false;

        return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }

    private boolean canPartition(int nums[], int index, int sum, int total, Map<String, Boolean> map) {
        String s = index + "" + sum;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (sum * 2 == total) {
            return true;
        }
        if (sum > total / 2 || index >= nums.length) {
            return false;
        }
        boolean result = canPartition(nums, index + 1, sum, total, map) || canPartition(nums, index + 1, sum + nums[index], total, map);
        map.put(s, result);
        return result;
    }
}
