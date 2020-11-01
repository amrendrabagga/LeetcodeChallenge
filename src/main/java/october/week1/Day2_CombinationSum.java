package october.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        int nums[] = Arrays.stream(candidates).distinct().toArray();
        findNumbers(nums, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void findNumbers(int[] nums, List<List<Integer>> res, List<Integer> list, int sum, int i) {
        if (sum < 0)
            return;

        if (sum == 0)
            res.add(new ArrayList<>(list));

        while (i < nums.length && sum - nums[i] >= 0) {
            list.add(nums[i]);
            findNumbers(nums, res, list, sum - nums[i], i);
            i++;
            list.remove(list.size() - 1);
        }
    }
}
