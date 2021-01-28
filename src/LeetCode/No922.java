package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/11/12 10:41
 * @description：
 */
public class No922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int x = 0 , y = 1;
        for (int i = 0 ; i < A.length ; i ++){
            if (A[i] % 2 == 1){
                result[y] = A[i];
                y += 2;
            }
            else {
                result[x] = A[i];
                x += 2;
            }
        }
        return result;
    }
}
