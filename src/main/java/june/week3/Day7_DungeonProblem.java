package june.week3;

public class Day7_DungeonProblem {

    public static int calculateMinimumHP(int[][] dungeon) {

        int M = dungeon.length;
        int N = dungeon[0].length;
        int [][]dp = new int[M][N];

        // here since path is based on future values, we use bottom up approach
        // stating min health required to begin with
        dp[M-1][N-1] = dungeon[M-1][N-1] > 0 ? 1 : Math.abs(dungeon[M-1][N-1]) + 1;

        for (int i=M-2; i>=0; i--) {
            // heath required from previous step to reach next step
            // last - current, if negative then set to base value 1 as health cannot be negative
            dp[i][N-1] = Math.max(dp[i+1][N-1] - dungeon[i][N-1], 1);
        }

        for (int j= N-2; j>=0; j--) {
            dp[M-1][j] = Math.max(dp[M-1][j+1] - dungeon[M-1][j], 1);
        }

        for (int i=M-2; i>=0; i--) {
            for (int j=N-2; j>=0; j--) {
                int minStepsToReachCurrentLocation  = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(minStepsToReachCurrentLocation - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int [][]dungeon = {
                {0,-3}//,
//                {-5,-10,1},
//                {10,30,-5}
        };
        System.out.println(calculateMinimumHP(dungeon));
    }
}
