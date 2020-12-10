package december.week2;

public class Day3_ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 1;
        while (i < n && arr[i] > arr[i-1]) i++;
        if (i ==1 || i == n) return false;
        while (i < n && arr[i] < arr[i-1]) i++;
        return i == n;
    }
}
