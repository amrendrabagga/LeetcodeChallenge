package june.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day6_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return Collections.emptyList();
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int[] count = new int[nums.length];
        int prev[] = new int[nums.length];

        Arrays.fill(count, 1);
        Arrays.fill(prev, -1);

        int j=0;
        int maxCountIndex = 0;
        for(int i=1; i<nums.length; i++) {
            for(j=0; j<i; j++) {
                if (nums[i]%nums[j] ==0 && count[i] < count[j]+1) {
                    prev[i] = j;
                    count[i] = count[j] + 1;
                }
            }
            if (count[i] > count[maxCountIndex])
                maxCountIndex = i;
        }

        int k = maxCountIndex;
        while (k>=0) {
            result.add(nums[k]);
            k = prev[k];
        }
        return result;
    }
}
