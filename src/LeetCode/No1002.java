package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：CK
 * @date ：Created in 2020/10/14 10:37
 * @description：
 */
public class No1002 {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        Map<String,Integer> minMap = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        for (int j = 0 ; j < A.length ; j++){
            String a = A[j];
            map.clear();
            for (int i = 0 ; i < a.length() ; i ++){
                if (map.containsKey(a.substring(i,i+1))){
                    map.put(a.substring(i,i+1),map.get(a.substring(i,i+1))+1);
                }
                else {
                    map.put(a.substring(i,i+1),1);
                }
            }
            if (j == 0){
                minMap.putAll(map);
            }
            else {
                for (String key : minMap.keySet()) {
                    minMap.put(key,Math.min(map.getOrDefault(key,0),minMap.getOrDefault(key,0)));
                }
            }
        }
        for (String key:minMap.keySet()){
            int x = minMap.get(key);
            while (x>0){
                result.add(key);
                x--;
            }
        }
        return result;
    }
}
