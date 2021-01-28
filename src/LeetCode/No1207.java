package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：CK
 * @date ：Created in 2020/10/28 10:32
 * @description：
 */
public class No1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr){
            if (integerMap.containsKey(i)){
                integerMap.put(i,integerMap.get(i)+1);
                countMap.put(integerMap.get(i)-1,countMap.get(integerMap.get(i)-1)-1);
                countMap.put(integerMap.get(i),countMap.getOrDefault(integerMap.get(i),0)+1);
            }
            else {
                integerMap.put(i,1);
                countMap.put(1,countMap.getOrDefault(1,0)+1);
            }
        }
        for (int key:countMap.keySet()){
            if (countMap.get(key)>1){
                return false;
            }
        }
        return true;
    }
}
