package october.week3;

public class Day4_BuyAndSellWithMaxKTransaction {
    public int maxProfit(int k, int[] prices) {
        if (k <=0 || prices.length <= 1)
            return 0;
        // if k transaction is greater than n/2, means we can use greedy approach
        // reduces to problem to give max profit with infinite transaction
        if (k >= prices.length/2) {
            int profit = 0;
            for (int i=1; i<prices.length; i++) {
                if (prices[i] > prices[i-1])
                    profit += prices[i] - prices[i-1];
            }
            return profit;
        }

        int dp[][] = new int[k+1][prices.length];

        for (int i=1; i<dp.length; i++) {
            int maxDiff = -prices[0];
            for (int j=1; j<dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i-1][j] - prices[j]);
            }
        }

        return dp[k][prices.length-1];
    }
}
