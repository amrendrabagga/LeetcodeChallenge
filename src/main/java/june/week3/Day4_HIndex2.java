package june.week3;

public class Day4_HIndex2 {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int low = 0;
        int high = citations.length - 1;
        int n = citations.length;

        while (low < high) {
            int mid = (low + high)/2;
            if (n - mid == citations[mid]) {
                low = mid;
                break;
            }
            else if (n - mid < citations[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return Math.min(n-low, citations[low]);
    }
}
