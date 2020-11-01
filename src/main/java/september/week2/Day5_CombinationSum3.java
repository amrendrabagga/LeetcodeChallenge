package september.week2;

import java.util.ArrayList;
import java.util.List;

public class Day5_CombinationSum3 {
    int K;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList();
        K = k;
        combinationSumUtil(1, k, n, new ArrayList<Integer>());
        return res;
    }
    private void combinationSumUtil(int index, int k, int n, List<Integer> list) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList(list));
            }
            return;
        }
        k--;
        for (int i=index; i<=9; i++) {
            list.add(i);
            combinationSumUtil(i + 1, k, n - i, list);
            list.remove(K - k -1);
        }
    }

    public static void main(String[] args) {
        Day5_CombinationSum3 obj = new Day5_CombinationSum3();
        System.out.println(obj.combinationSum3(3, 7));
    }
}
