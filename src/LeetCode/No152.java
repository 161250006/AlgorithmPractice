package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2021/1/20 10:33
 * @description：
 */
public class No152 {
    //0是最小值，1是最大值
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        int max = nums[0];
        dp[0][0] = dp[0][1] = nums[0];
        for (int i = 1 ; i < nums.length ; i ++){
            dp[i][0] = Math.min(nums[i], Math.min(dp[i-1][0] * nums[i] , dp[i-1][1] * nums[i]));
            dp[i][1] = Math.max(nums[i], Math.max(dp[i-1][1] * nums[i] , dp[i-1][0] * nums[i]));
            max = Math.max(max,dp[i][1]);
        }
        return max;
    }
}
