package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：CK
 * @date ：Created in 2020/11/22 10:48
 * @description：
 */
public class No242 {
    public boolean isAnagram(String s, String t) {
        Map<String,Integer> mapS = new HashMap<>() , mapT = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i ++){
            String a = s.substring(i,i+1);
            mapS.put(a,mapS.getOrDefault(a,0)+1);
        }
        for (int i = 0 ; i < t.length() ; i ++){
            String a = t.substring(i,i+1);
            mapT.put(a,mapT.getOrDefault(a,0)+1);
        }
        for (String x : mapS.keySet()){
            if (!mapT.getOrDefault(x, 0).equals(mapS.get(x))){
                return false;
            }
        }
        for (String x : mapT.keySet()){
            if (!mapS.getOrDefault(x, 0).equals(mapT.get(x))){
                return false;
            }
        }
        return true;
    }
}
