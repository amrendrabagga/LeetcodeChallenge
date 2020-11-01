package september.week5;

import java.util.HashSet;

public class Day2_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        HashSet<Integer> set = new HashSet();
        for (int n : nums) {
            set.add(n);
        }
        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }

    public int firstMissingPositiveEfficient(int nums[]) {
        if (nums.length == 0)
            return 1;
        int n = nums.length;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 1;
        }

        for (int i=0; i<nums.length; i++) {
            int id = Math.abs(nums[i]);
            if (id > n) continue;
            id--;
            if (nums[id] > 0) nums[id] = -1 * nums[id];
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) return i+1;
        }
        return n+1;
    }
}
