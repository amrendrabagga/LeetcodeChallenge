package november.week2;

import java.util.*;
import java.util.stream.Collectors;

public class Day5_Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length ==0)
            return new ArrayList();

        Set<List<Integer>> res = new HashSet();
        permuteUniqueUtils(nums, res, 0);
        return new ArrayList(res);
    }

    private void permuteUniqueUtils(int nums[], Set<List<Integer>> res, int st) {
        if (st == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i=st; i<nums.length; i++) {
            swap(nums, st, i);
            permuteUniqueUtils(nums, res, st + 1);
            swap(nums, i, st);
        }
    }
    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Day5_Permutation2 obj = new Day5_Permutation2();
        System.out.println(obj.permuteUnique(new int[]{1,1,2}));

    }
}
