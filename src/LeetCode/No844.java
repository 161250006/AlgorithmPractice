package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/19 9:58
 * @description：
 */
public class No844 {
    public boolean backspaceCompare(String S, String T) {
        StringBuffer Ssb = new StringBuffer();
        StringBuffer Tsb = new StringBuffer();
        for (int i = 0; i<S.length();i++){
            if (S.charAt(i) == '#') {
                if (Ssb.length() > 0){
                    Ssb.deleteCharAt(Ssb.length() - 1);
                }
            }
            else {
                Ssb.append(S.charAt(i));
            }
        }
        for (int i = 0; i<T.length();i++){
            if (T.charAt(i) == '#') {
                if (Tsb.length() > 0){
                    Tsb.deleteCharAt(Tsb.length() - 1);
                }
            }
            else {
                Tsb.append(T.charAt(i));
            }
        }
        return Ssb.toString().equals(Tsb.toString());
    }

    //双指针，逆序遍历
    public boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}
