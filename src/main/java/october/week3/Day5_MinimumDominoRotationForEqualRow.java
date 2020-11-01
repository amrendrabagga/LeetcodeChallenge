package october.week3;

public class Day5_MinimumDominoRotationForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] sameCount = new int[7];

        for (int i=0; i<n; i++) {
            int a = A[i];
            int b = B[i];
            countA[a]++;
            countB[b]++;
            if (a == b) sameCount[a]++;
        }
        int res = n;
        for (int i=1; i<7; i++) {
            if (countA[i] + countB[i] - sameCount[i] == n) {
                int min = Math.min(countA[i], countB[i]) - sameCount[i];
                res = Math.min(res, min);
            }
        }
        return res == n ? -1 : res;
    }
}
