package december.week4;

public class Day5_DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=2; i<dp.length; i++) {
            if (s.charAt(i-1) != '0')
                dp[i] += dp[i-1];
            int no = Integer.parseInt(s.substring(i-2, i));
            if (no >= 10 && no <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
