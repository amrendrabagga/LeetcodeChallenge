package october.week4;

import java.util.ArrayList;
import java.util.List;

public class Day7_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return new ArrayList();
        List<String> res = new ArrayList();

        int i=0;
        while (i < nums.length) {
            int j = i+1;
            String t = "" + nums[i];
            while (j < nums.length && nums[j] == nums[j-1] + 1) {
                j++;
            }
            if (nums[i] == nums[j-1])
                res.add("" + nums[i]);
            else
                res.add(nums[i] + "->" + nums[j-1]);
            i = j;
        }
        return res;
    }
}
