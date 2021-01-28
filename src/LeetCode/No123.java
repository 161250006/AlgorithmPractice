package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/11/8 11:42
 * @description：
 */
public class No123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][5];
        for (int i = 0 ; i <= 4 ; i++){
            dp[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 0 ; i <= prices.length ; i++){
            dp[i][0] = 0;
        }
        for (int i = 1 ; i < prices.length + 1 ; i ++){
            dp[i][1] = Math.max(dp[i - 1][1] , dp[i][0] -prices[i - 1]);
            dp[i][2] = Math.max(dp[i][1] + prices[i - 1] , dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][3] , dp[i][2] - prices[i - 1]);
            dp[i][4] = Math.max(dp[i][3] + prices[i - 1] , dp[i - 1][4]);
        }
        return dp[prices.length][4];
    }
}
