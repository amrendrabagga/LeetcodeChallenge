package july.week2;

public class Day5_ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++) {
            res = (res << 1) | (n & 1);
            n>>=1;
        }
        return res;
    }
}
