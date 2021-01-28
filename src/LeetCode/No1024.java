package LeetCode;

import java.util.Arrays;

/**
 * @author ：CK
 * @date ：Created in 2020/10/24 10:27
 * @description：
 */
public class No1024 {

    //dp,注意是区间是(,]
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];

        //初始化
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1 ; i <= T ; i++){
            for (int j = 0 ; j < clips.length ; j ++){
                if (clips[j][0] < i && clips[j][1] >= i){
                    dp[i] = Math.min(dp[clips[j][0]] + 1,dp[i]);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    //贪心
    public int videoStitching1(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }
}
