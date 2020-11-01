package june.week2;

public class Day1_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n < 0)
            return false;
        return (n & (n-1)) == 0;
    }
}
