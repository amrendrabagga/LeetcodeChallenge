package october.week5;

public class Day1_MaximiseDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        if (seats.length == 0)
            return 0;
        int maxDist = 0;
        int l = -1;
        int n = seats.length;
        for (int i=0; i<n; i++) {
            if (seats[i] == 1) {
                // calculate maxDist when we get occupied set cause we store last seat position so,
                // prev seat will be closest to curr, and go on..
                if (l == -1)
                    maxDist = i;
                else {
                    maxDist = Math.max(maxDist, (i-l)/2);
                }
                l = i;
            }
        }
        // end case when we reach to end of seats and seat is not occupied then diff bw curr pointer
        // and last occupied seat is maxDist, likewise first case;
        // when first seat occupied is not at 0th index
        maxDist = Math.max(maxDist, n - l - 1);
        return maxDist;
    }

    public static void main(String[] args) {
        Day1_MaximiseDistanceToClosestPerson obj = new Day1_MaximiseDistanceToClosestPerson();
        System.out.println(obj.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }
}
