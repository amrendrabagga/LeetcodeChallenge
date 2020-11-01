package october.week4;

public class Day4_StoneGame4 {
    // Alice will win if -
    // after deducting perfect square from current n on Bob's turn, we are left with
    // stones such that Alice can take all stones remaining in their turn

    //Ex on n=1 alice can take all stones at single instance
    // Ex on n=2, if ALice takes 1 then Bob's takes 1, thus leaving nothing for Alice thus false
    // n=3 A->1->B->1->A->1
    public boolean winnerSquareGame(int n) {
        boolean dp[] = new boolean[n + 1];
        dp[0] = false;
        for (int i=1; i<=n; i++) {
            for (int j=1; j*j<=i; j++) { // considering all perfect squares less than ith stone
                if (!dp[i-j*j])
                    dp[i] = true;
            }
        }
        return dp[n];
    }
}
