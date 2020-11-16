package november.week3;

public class Day2_LongestMountainInArray {
    public int longestMountain(int[] A) {
        int i = 0;
        int j = 0;
        int n = A.length;
        int res = 0;
        while (i < n && j < n) {
            j = i;
            if (j < n - 1 && A[j] < A[j + 1]) {
                while (j < n - 1 && A[j] < A[j + 1]) j++;

                if (j < n - 1 && A[j] > A[j + 1]) {
                    while (j < n - 1 && A[j] > A[j + 1]) j++;
                    res = Math.max(res, j - i + 1);
                }
            }

            i = Math.max(i+1, j);
        }
        return res;

    }
}
