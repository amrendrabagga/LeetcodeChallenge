package november.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        for (int[] interval : intervals) {
            if (res.size() == 0)
                res.add(interval);
            else {
                int[] lastInterval = res.get(res.size() - 1);
                if (lastInterval[1] >= interval[0]) {
                    int lastMax = Math.max(lastInterval[1], interval[1]);
                    int start = lastInterval[0];
                    res.remove(res.size() - 1);
                    res.add(new int[]{start, lastMax});
                }
                else
                    res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
