package LeetCode;

import java.util.Arrays;

/**
 * @author ：CK
 * @date ：Created in 2020/11/29 10:54
 * @description：
 */
public class No976 {
    public int largestPerimeter(int[] A) {
        if (A.length < 3){
            return 0;
        }
        Arrays.sort(A);
        int a = A.length - 2 , b = A.length - 1 , c = A.length;
        for (int i = A.length - 3 ; i >= 0 ; i --){
            c = b;
            b = a;
            a = i;
            if (A[a] + A[b] > A[c]){
                return A[a] + A[b] + A[c];
            }
        }
        return 0;
    }
}
