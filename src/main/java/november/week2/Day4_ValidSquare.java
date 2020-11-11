package november.week2;

public class Day4_ValidSquare {

    private int squareDistance(int[] p1, int[]p2) {
        return Math.abs((p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d2 = squareDistance(p1, p2);
        int d3 = squareDistance(p1, p3);
        int d4 = squareDistance(p1, p4);
        if (d2 ==0 && d3 == 0 && d4 == 0)
            return false;
        // taking combination of 2 points
        // comparing their distance are equal
        // distance to point that was left one is equal to twice of one selected 2a^2 = a^2
        // also compute distance between 3rd point(diagonal point) to others are equal

        // taking p2 and p3 are equal with p4 being diagonally located
        if (d2 == d3 && ((2 * d2) == d4) && squareDistance(p2, p4) == squareDistance(p3, p4))
            return true;

        // taking p2 and p4 are equal with p3 being diagonally located
        if (d2 == d4 && ((2 * d2) == d3) && squareDistance(p2, p3) == squareDistance(p3, p4))
            return true;

        // taking p3 and p4 are equal with p2 being diagonally located
        if (d3 == d4 && ((2 * d3) == d2) && squareDistance(p3, p2) == squareDistance(p4, p2))
            return true;

        return false;
    }
}
