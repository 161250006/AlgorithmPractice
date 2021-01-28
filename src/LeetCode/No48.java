package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/12/19 10:55
 * @description：
 */
public class No48 {
    //原地旋转，我自己写的
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len < 2){
            return;
        }
        int begin = 0;
        int p = 0;
        while (len > 1){
            for (int i = begin ; i < begin + len - 1 ; i++) {
                p = matrix[begin][i];
                matrix[begin][i] = matrix[matrix.length - i - 1][begin];
                matrix[matrix.length - i - 1][begin] = matrix[matrix.length - begin - 1][matrix.length - i - 1];
                matrix[matrix.length - begin - 1][matrix.length - i - 1] = matrix[i][matrix.length - begin - 1];
                matrix[i][matrix.length - begin - 1] = p;
            }
            begin += 1;
            len -= 2;
        }
    }

    //转化为翻转问题，先水平翻转，然后再对角线翻转
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
