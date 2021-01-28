package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：CK
 * @date ：Created in 2020/10/22 10:09
 * @description：
 */
public class No763 {
    //可以不用记录起始位置，只需要结束为止即可
    public List<Integer> partitionLabels(String S) {
        List result = new ArrayList();
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0 ; i < S.length() ; i ++){
            if (map.containsKey(S.substring(i,i+1))){
                int[] temp = map.get(S.substring(i,i+1));
                temp[1] = i;
                map.put(S.substring(i,i+1),temp);
            }
            else {
                map.put(S.substring(i,i+1),new int[]{i,i});
            }
        }
        int start = 0 , end = 0;
        while (start<S.length()){
            end = map.get(S.substring(start,start+1))[1];
            for (int i = start ; i < end ; i ++){
                if (map.get(S.substring(i,i+1))[1]>end){
                    end = map.get(S.substring(i,i+1))[1];
                }
            }
            result.add(end-start+1);
            start = end + 1;
        }
        return result;
    }
}
