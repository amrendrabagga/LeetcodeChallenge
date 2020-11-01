package september.week3;

import java.util.PriorityQueue;

public class Day7_CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->{
            if (o1[2] > o2[2])
                return 1;
            else if (o1[2] < o2[2])
                return -1;
            else return 0;
        });
        queue.add(trips[0]);
        capacity -= trips[0][0];
        for (int i=1; i<trips.length; i++) {
            while (!queue.isEmpty() && queue.peek()[2] <= trips[i][1]) {
                int[] t = queue.poll();
                capacity += t[0];
            }
            if(trips[i][0] > capacity) return false;
            queue.add(trips[i]);
            capacity -= trips[i][0];

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{2,2,6},{2,4,7},{8,6,7}};
//        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
//        for (int[] t : arr) {
//            System.out.println(Arrays.toString(t));
//        }
        System.out.println(carPooling(arr, 11));
    }
}
