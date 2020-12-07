package december.week1;

public class Day7_SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int A[][] = new int[n][n];
        int top = 0, left = 0, right = n-1, bottom = n-1;
        int val = 1;
        while (val <= n * n) {
            for (int i=left; i<=right; i++) {
                A[top][i] = val++;
            }
            top++;
            for (int i=top; i<=bottom; i++) {
                A[i][right] = val++;
            }
            right--;
            for (int i=right; i>=left; i--) {
                A[bottom][i] = val++;
            }
            bottom--;
            for (int i=bottom; i>=top; i--) {
                A[i][left] = val++;
            }
            left++;
            // val++;
        }
        return A;
    }
}
