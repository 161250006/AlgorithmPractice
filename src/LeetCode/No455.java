package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：CK
 * @date ：Created in 2020/12/25 10:00
 * @description：
 */
public class No455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        int sum = 0;
        Arrays.sort(s);
        int j = s.length - 1;
        for (int i = g.length - 1 ; i >= 0 ; i --){
            if (j < 0){
                return sum;
            }
            if (s[j] >= g[i]){
                sum++;
                j--;
            }
        }
        return sum;
    }
}
