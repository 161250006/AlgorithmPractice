package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：CK
 * @date ：Created in 2020/11/6 21:04
 * @description：
 */
public class No1356 {
    public int[] sortByBits(int[] arr) {
        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());
        result.sort((a,b) ->{
            int countA = getCount(a),countB = getCount(b);
            if (countA == countB){
                return a - b;
            }
            else {
                return countA - countB;
            }
        });
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int getCount(int a){
        int sum = 0;
        while (a>0){
            sum += a % 2;
            a /= 2;
        }
        return sum;
    }
}
