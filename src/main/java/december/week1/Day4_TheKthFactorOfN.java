package december.week1;

public class Day4_TheKthFactorOfN {
    public int kthFactor(int n, int k) {
        // if (k == 1) return 1;
        int t = 1;
        while (t <= n) {
            if (n % t == 0) {
                if (--k == 0) return t;
            }
            t++;
        }
        return -1;
    }
}
