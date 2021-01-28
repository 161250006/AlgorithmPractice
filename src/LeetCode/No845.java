package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/25 10:23
 * @description：
 */
public class No845 {
    public int longestMountain(int[] A) {
        if (A.length < 3){
            return 0;
        }
        int length = 0;
        int k = 0;
        int i = 0 , j = 1;
        while (j < A.length){
            if (k == 0){
                if (A[j-1] > A[j]){
                    if (i == j-1) {
                        i = j;
                    }
                    else {
                        if (j == (A.length - 1)){
                            length = Math.max(j - i + 1, length);
                        }
                        k = 1;
                    }
                }
                else if (A[j-1] == A[j]){
                    i = j;
                }
            }
            else {
                if (A[j-1] < A[j]){
                    length = Math.max(j - i, length);
                    i = j -1;
                    k = 0;
                }
                else if (A[j-1] == A[j]){
                    length = Math.max(j - i, length);
                    i = j;
                    k = 0;
                }
                else if (j == (A.length - 1)){
                    length = Math.max(j - i + 1, length);
                }
            }
            j ++;
        }
        return length;
    }

    //dp
    public int longestMountain2(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
