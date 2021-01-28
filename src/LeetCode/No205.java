package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：CK
 * @date ：Created in 2020/12/27 11:46
 * @description：
 */
public class No205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i ++){
            if (map.containsKey(s.charAt(i))){
                if (t.charAt(i)!=map.get(s.charAt(i))){
                    return false;
                }
            }
            else {
                if (map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}
