package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：CK
 * @date ：Created in 2020/12/24 10:20
 * @description：
 */
public class No135 {
    //自己写的，太复杂了
    public int candy(int[] ratings) {
        if (ratings.length == 0){
            return 0;
        }
        if (ratings.length == 1){
            return 1;
        }
        int sum = 0;
        int pre = 0;
        int k = 0;
        if (ratings[0] <= ratings[1]){
            k = 0;
        }
        else {
            k = 1;
        }
        List<int[]> list = new ArrayList<>();
        int[] result = new int[ratings.length];
        for(int i = 0 ; i < ratings.length ; i ++){
            if (i == ratings.length - 1){
                list.add(new int[]{pre,i,k});
                break;
            }
            if (k == 0){
                if (ratings[i] >= ratings[i+1]){
                    list.add(new int[]{pre,i,0});
                    if (ratings[i] == ratings[i + 1]){
                        pre = i+1;
                    }
                    else {
                        pre = i;
                    }
                    k = 1;
                }
            }
            else {
                if (ratings[i] <= ratings[i+1]){
                    list.add(new int[]{pre,i,1});
                    if (ratings[i] == ratings[i + 1]){
                        pre = i+1;
                    }
                    else {
                        pre = i;
                    }
                    k = 0;
                }
            }
        }
        for (int[] x : list){
            int t = 1;
            if (x[2] == 0) {
                for (int i = x[0]; i <= x[1]; i++) {
                    result[i] = Math.max(result[i],t);
                    t ++;
                }
            }
            else {
                for (int i = x[1]; i >= x[0]; i--) {
                    result[i] = Math.max(result[i],t);
                    t ++;
                }
            }
        }
        for (int x : result){
            sum += x;
        }
        return sum;
    }

    //分两次遍历，分别区分比左边大和比右边大的，比之前大就+1，没有就设置为1，然后取得最大值（比我简单多了，但其实思想差不多）
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    //常数空间优化，说实话没有必要
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}
