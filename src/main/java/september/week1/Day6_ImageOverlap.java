package september.week1;

public class Day6_ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {
        return Math.max(shiftCount(A, B), shiftCount(B, A));
    }

    private int shiftCount(int[][] A, int[][] B) {
        /**
         * here we are moving only B while keeping A fixed
         * and we move in dir x and y; in right dir and down dir respectively
         * we call this method with with arguments (A, B) then with (B, A)
         * thus making A move in all four direction
         **/
        int n = A.length;
        int count = 0;
        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                int tmp = 0;
                for (int i=y; i<n; i++) {
                    for (int j=x; j<n; j++) {
                        if (A[i][j] == 1 && B[i-y][j-x] == 1)
                            tmp++;
                    }
                }
                count = Math.max(count, tmp);
            }
        }
        return count;
    }
}
