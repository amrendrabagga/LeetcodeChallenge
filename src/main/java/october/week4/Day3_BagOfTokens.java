package october.week4;

import java.util.Arrays;

public class Day3_BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int maxPoints = 0;
        int points = 0;
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (P >= tokens[i]) {// to maximum score we will face up
                points++;
                P -= tokens[i++];
                maxPoints = Math.max(maxPoints, points);
            }
            else if (points > 0) {// insufficient power than try to gain power by losing score
                points--;
                P += tokens[j--];
            }
            else {// this case handles if we dont have power to face up and no score to face down for power gain
                // that satisfies condition to not use every token
                break;
            }
        }
        return maxPoints;
    }
}
