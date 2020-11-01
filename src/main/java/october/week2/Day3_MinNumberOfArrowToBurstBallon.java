package october.week2;

import java.util.Arrays;
import java.util.Comparator;

public class Day3_MinNumberOfArrowToBurstBallon {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points.length == 1)
            return points.length;

        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int count = 1;
        int maxTillNow = points[0][1];

        for (int i=1; i<points.length; i++) {
            if (points[i][0] > maxTillNow) {
                maxTillNow = points[i][1];
                count++;
            }
            else {
                maxTillNow = Math.min(maxTillNow, points[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Day3_MinNumberOfArrowToBurstBallon obj = new Day3_MinNumberOfArrowToBurstBallon();
        System.out.println(obj.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));

    }
}
