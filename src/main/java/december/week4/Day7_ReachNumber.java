package december.week4;

public class Day7_ReachNumber {
    public int reachNumber(int target) {
        if (target < 0) {
            target = -target;
        }
        int position = 0;
        int n = 0;
        while (position < target) {
            n += 1;
            position += n;
        }
        if (target == position)
            return n;
        else {
            int k = position - target;
            if (k % 2 == 0) return n;
            if ((n + 1) % 2 == 1) return n + 1;
            else
                return n + 2;
        }
    }
}
