package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/21 10:19
 * @description：
 */
public class No925 {
    public boolean isLongPressedName(String name, String typed) {
        int i=0,j=0,k=0;
        while (i<name.length() && j<typed.length()){
            if (name.charAt(i)==typed.charAt(j)){
                k=i;
                i++;
                j++;
            }
            else if (name.charAt(k) == typed.charAt(j)){
                j++;
            }
            else {
                return false;
            }
        }
        if (i==name.length()){
            if (j==typed.length()){
                return true;
            }
            else {
                while (j<typed.length()){
                    if (name.charAt(i-1)!=typed.charAt(j)){
                        return false;
                    }
                    j++;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
