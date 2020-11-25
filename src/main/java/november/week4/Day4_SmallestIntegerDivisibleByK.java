package november.week4;

public class Day4_SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        // int len = 1;
        int number = 0;
        for (int len = 1; len <= K; len++) {
            number = (number *10 + 1) % K;
            if (number == 0) return len;
        }
        return -1;
    }
}
