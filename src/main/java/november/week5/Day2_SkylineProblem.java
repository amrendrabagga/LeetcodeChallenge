package november.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Day2_SkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0)
            return Arrays.asList();
        BuildingPoint[] points = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int[] building : buildings) {
            points[index] = new BuildingPoint(building[0], true, building[2]);

            points[index + 1] = new BuildingPoint(building[1], false, building[2]);
            index += 2;
        }

        List<List<Integer>> res = new ArrayList();
        Arrays.sort(points);
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(0, 1);
        int prevMax = 0;
        for (BuildingPoint point : points) {
            if (point.isStart) {
                map.compute(point.height, (key, value) -> value == null ? 1 : value + 1);
            }
            else {
                map.compute(point.height, (key, value) -> value == 1 ? null : value - 1);
            }
            int currMax = map.lastKey();
            if (prevMax != currMax) {
                res.add(Arrays.asList(point.x, currMax));
                prevMax = currMax;
            }
        }
        return res;
    }


    static class BuildingPoint implements Comparable<BuildingPoint> {
        public int x;
        public boolean isStart;
        public int height;

        public BuildingPoint(int x, boolean isStart, int height) {
            this.x = x;
            this.isStart = isStart;
            this.height = height;
        }

        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                return this.x - o.x;
            }
            return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
        }
    }
}
