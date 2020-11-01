package september.week4;

public class Day5_TeemoAttack {
    public int findPoisonedDuration(int[] times, int duration) {
        if (times.length == 0) return 0;
        int res = duration;
        for (int i=0; i<times.length-1; i++) {
            res += Math.min(duration, times[i+1] - times[i]);
        }
        return res;
    }
}
