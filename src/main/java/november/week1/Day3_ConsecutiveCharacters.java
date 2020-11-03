package november.week1;

public class Day3_ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int max = 1;
        int curr = 1;
        for (int i=1; i<s.length(); i++) {
            curr = (s.charAt(i) == s.charAt(i-1)) ? curr + 1: 1;
            max = Math.max(max, curr);
        }
        return max;
    }
}
