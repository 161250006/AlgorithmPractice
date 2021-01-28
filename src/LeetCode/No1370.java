package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/11/25 11:37
 * @description：
 */
public class No1370 {
    public String sortString(String s) {
        char pre = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder(s);
        boolean k = false;
        while (stringBuilder.length() != 0){
            int removeInt = 0;
            if (!k){
                char remove = Character.MAX_VALUE;
                char max = 0;
                int maxInt = 0;
                for (int i = 0 ; i < stringBuilder.length() ; i ++){
                    if (stringBuilder.charAt(i) > pre && stringBuilder.charAt(i) < remove){
                        remove = stringBuilder.charAt(i);
                        removeInt = i;
                    }
                    if (stringBuilder.charAt(i)>max){
                        max = stringBuilder.charAt(i);
                        maxInt = i;
                    }
                }
                if (remove == Character.MAX_VALUE){
                    k = true;
                    result.append(max);
                    stringBuilder.deleteCharAt(maxInt);
                    pre = max;
                    continue;
                }
                stringBuilder.deleteCharAt(removeInt);
                result.append(remove);
                pre = remove;
            }
            else {
                char remove = 0;
                char min = Character.MAX_VALUE;
                int minInt = 0;
                for (int i = 0 ; i < stringBuilder.length() ; i ++){
                    if (stringBuilder.charAt(i) < pre && stringBuilder.charAt(i) > remove){
                        remove = stringBuilder.charAt(i);
                        removeInt = i;
                    }
                    if (stringBuilder.charAt(i)<min){
                        min = stringBuilder.charAt(i);
                        minInt = i;
                    }
                }
                if (remove == 0){
                    k = false;
                    result.append(min);
                    stringBuilder.deleteCharAt(minInt);
                    pre = min;
                    continue;
                }
                stringBuilder.deleteCharAt(removeInt);
                result.append(remove);
                pre = remove;
            }
        }
        return result.toString();
    }

    //桶计数...,因为和字符串没有关系
    public String sortString1(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer ret = new StringBuffer();
        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
        return ret.toString();
    }
}
