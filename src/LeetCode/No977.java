package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/16 10:02
 * @description：
 */
public class No977 {
    public int[] sortedSquares(int[] A) {
        if (A == null && A.length == 0){
            return A;
        }
        int x = 0 , y = 0;
        for (int i = 0 ; i < A.length ; i++ ){
            if (A[i] < 0){
                x++;
            }
            else {
                break;
            }
        }
        y = x;
        x --;
        int [] B = new int[A.length];
        for (int i = 0 ; i < A.length ; i++){
            if (x >= 0 && y < A.length) {
                if (A[x] * A[x] <= A[y] * A[y]) {
                    B[i] = A[x] * A[x];
                    x--;
                }
                else {
                    B[i] = A[y] * A[y];
                    y++;
                }
            }
            else if (x >= 0){
                B[i] = A[x] * A[x];
                x--;
            }
            else{
                B[i] = A[y] * A[y];
                y++;
            }
        }
        return B;
    }
}
