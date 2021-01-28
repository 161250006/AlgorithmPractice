package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/11/8 11:29
 * @description：
 */
public class No122 {
    public int maxProfit(int[] prices) {
        int sum = 0, pre = -1;
        for (int p : prices){
            if (pre != -1) {
                if (p > pre) {
                    sum += p - pre;
                }
            }
            pre = p;
        }
        return sum;
    }
}
