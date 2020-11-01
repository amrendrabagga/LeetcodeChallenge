package october.week1;

public class Day5_ComplementOfBase10 {
    public int bitwiseComplement(int N) {
        int len = Integer.toBinaryString(N).length();
        int res = 0;
        for (int i=0; i<len; i++) {
            int b = (1 << i);
            if ((N & b) != 0)
                res |= 0 << 1;
            else
                res |= 1 << i;
        }
        return res;
    }

    public int bitwiseComplementEfficient(int N) {
        int len = Integer.toBinaryString(N).length();
        int mask = 1 << len;
        return N ^ (mask - 1);
    }

    public static void main(String[] args) {
        Day5_ComplementOfBase10 obj = new Day5_ComplementOfBase10();
        System.out.println(obj.bitwiseComplement(5));
    }
}
