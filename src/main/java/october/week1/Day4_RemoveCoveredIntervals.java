package october.week1;

import java.util.Arrays;

public class Day4_RemoveCoveredIntervals {
    public int removeCoveredIntervals2(int[][] intervals) {
        // count will keep track of uncovered interval
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int curr[] = new int[]{-1, -1};
        // int last = intervals[0][1];
        for (int i=0; i<intervals.length; i++) {
            if (intervals[i][0] > curr[0] && intervals[i][1] > curr[1]) {
                curr[0] = intervals[i][0];
                count++;
            }
            curr[1] = Math.max(curr[1], intervals[i][1]);

        }
        return count;
    }
    public int removeCoveredIntervals(int[][] intervals) {
        // count will keep track of covered interval
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int curr[] = new int[]{-1, -1};
        for (int in[] : intervals) {
            if (curr[0] <= in[0] && curr[1] >= in[1])
                count++;
            else {
                if (curr[0] >= in[0] && curr[1] <= in[1])
                    count++;
                curr = in;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        Day4_RemoveCoveredIntervals obj = new Day4_RemoveCoveredIntervals();
        obj.removeCoveredIntervals(new int[][]{{1,2},{1,4},{3,4}});
    }
}
