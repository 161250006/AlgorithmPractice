package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/12/15 11:40
 * @description：
 */
public class No738 {
    public int monotoneIncreasingDigits(int N) {
        StringBuilder result = new StringBuilder();
        char pre = 0;
        int change = 0;
        String num = String.valueOf(N);
        for (int i = 0 ; i < num.length() ; i ++){
            char now  = num.charAt(i);
            if (now > pre){
                result.append(now);
                change = i;
                pre = now;
            }
            else if (now == pre){
                result.append(now);
            }
            else {
                result.delete(change,result.length());
                result.append(num.charAt(change)-'1');
                for (int j = change + 1 ; j < num.length() ; j ++){
                    result.append("9");
                }
                break;
            }
        }
        return Integer.parseInt(result.toString());
    }
}
