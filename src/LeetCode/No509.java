package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2021/1/4 10:59
 * @description：
 */
public class No509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
