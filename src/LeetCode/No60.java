package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/9/5 9:42
 * @description：
 */
public class No60 {
    private int[] factorial;
    public String getPermutation(int n, int k) {
        int[] status = new int[n];
        calculateFactorial(n);
        return getOne(0, n, "", status, k);
    }
    public String getOne(int now, int n , String para, int[] status, int k) {
        if (now == n){
            return para;
        }
        int cnt = factorial[n - 1 - now];
        for (int i = 0 ; i < n ; i ++){
            if (status[i] != 0) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            status[i] = 1;
            String x = para + Integer.toString(i + 1);
            return getOne(now + 1, n, x, status, k);
        }
        return para;
    }

    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
