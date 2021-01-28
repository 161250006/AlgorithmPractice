package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2021/1/5 11:04
 * @description：
 */
public class No830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        char preChar = 0;
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int i = 0 ; i < s.length() ; i ++){
            if (s.charAt(i) == preChar){
                count++;
            }
            else {
                if (count >= 3){
                    result.add(Arrays.asList(i - count , i - 1));
                }
                preChar = s.charAt(i);
                count = 1;
            }
        }
        if (count >= 3){
            result.add(Arrays.asList(s.length() - count , s.length() - 1));
        }
        return result;
    }
}
