package december.week4;

import java.util.Arrays;

public class Day4_DiagonalTraverse {
    // upward - i-1, j+1, right or down
    // downward i+1, j-1 down or right
    public int[] findDiagonalOrder(int[][] matrix) {
        boolean up = true;
        int i=0, j=0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res[] = new int[m * n];
        int k = 0;
        while (k < res.length) {
            if (up) {
                for (;j < n && i >= 0; i--,j++) {
                    res[k] = matrix[i][j];
                    k++;
                }
                if (i < 0 && j <= n-1) {
                    i = 0;
                }
                if (j == n) {
                    i = i + 2;
                    j--;
                }
            }
            else {
                for (;j >= 0 && i < m; j--,i++) {
                    res[k] = matrix[i][j];
                    k++;
                }
                if (j < 0 && i <= m-1) {
                    j = 0;
                }
                if (i == m) {
                    j = j + 2;
                    i--;
                }
            }
            up = !up;
        }
        return res;
    }

    public static void main(String[] args) {
        Day4_DiagonalTraverse obj = new Day4_DiagonalTraverse();
        System.out.println(Arrays.toString(obj.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));

    }
}
