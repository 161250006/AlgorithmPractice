package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/12/28 10:07
 * @description：
 */
public class No188 {
    //答案分了两个数组，我自己写的，其实一个也能做，分一下奇偶数就行了
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2*k + 1];
        //初始化
        for (int i = 0 ; i < 2*k + 1 ; i ++){
            dp[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 0 ; i <= prices.length ; i ++){
            dp[i][0] = 0;
        }
        for (int i = 1 ; i <= prices.length ; i ++){
            for (int j = 1 ; j < 2*k + 1 ; j ++) {
                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i][j-1] - prices[i-1] , dp[i-1][j]);
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1] + prices[i-1] , dp[i-1][j]);
                }
            }
        }
        return dp[prices.length][2*k];
    }
}
