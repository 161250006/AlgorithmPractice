package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2021/1/22 11:51
 * @description：
 */
public class No989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0; --i) {
            int sum = A[i] + K % 10;
            K /= 10;
            //进位
            if (sum >= 10) {
                K++;
                sum -= 10;
            }
            res.add(sum);
        }
        //k更大的情况
        for (; K > 0; K /= 10) {
            res.add(K % 10);
        }
        //原先的res是小微在前，翻转得到结果
        Collections.reverse(res);
        return res;
    }
}
