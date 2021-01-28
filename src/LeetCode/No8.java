package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/13 22:43
 * @description：
 */
public class No8 {
    public int myAtoi(String s) {
        int newInt = 0;
        boolean k = false;
        int f = 1;
        for (int i = 0;i<s.length();i++){
            if (!k) {
                if (s.substring(i, i + 1).equals(" ")) {
                    continue;
                }
                else if (s.substring(i, i + 1).equals("+")){
                    k = true;
                }
                else if (s.substring(i, i + 1).equals("-")){
                    f = -1;
                    k = true;
                }
                else if (Character.isDigit(s.charAt(i))){
                    newInt += Integer.parseInt(s.substring(i,i+1));
                    k = true;
                }
                else {
                    return 0;
                }
            }
            else {
                if (Character.isDigit(s.charAt(i))){
                    try {
                        newInt = Math.multiplyExact(newInt,10);
                        newInt = Math.addExact(newInt,Integer.parseInt(s.substring(i,i+1)));
                    }
                    catch (ArithmeticException e){
                        if (f > 0){
                            return Integer.MAX_VALUE;
                        }
                        else {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                else {
                    break;
                }
            }
        }
        return newInt * f;
    }
}
