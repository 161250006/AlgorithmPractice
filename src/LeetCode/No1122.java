package LeetCode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：CK
 * @date ：Created in 2020/11/14 10:27
 * @description：
 */
public class No1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : arr1){
            if (Arrays.stream(arr2).boxed().collect(Collectors.toList()).contains(i)) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            else {
                list.add(i);
            }
        }
        Collections.sort(list);
        for (int i : arr2){
            int x = map.getOrDefault(i,0);
            while (x > 0){
                result.add(i);
                x--;
            }
        }
        result.addAll(list);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    //自定义排序方法
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Collections.sort(list, (x, y) -> {
            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }

    //计数排序，和我的类似
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
