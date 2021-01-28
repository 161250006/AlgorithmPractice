package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/13 10:38
 * @description：
 */
public class No7 {
    public int reverse(int x) {
        int flag = 0;
        int newInt = 0;
        int i = 1;
        int j = 1;
        while (x / i != 0){
            try {
                i = Math.multiplyExact(i,10);
            }
            catch (ArithmeticException e){
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            i /= 10;
        }
        while (i > 0){
            int num = x / i;
            try {
                newInt = Math.addExact(newInt, Math.multiplyExact(j , num));
                x = x % i;
                i /= 10;
                j *= 10;
            }
            catch (ArithmeticException e){
                return 0;
            }
        }
        return newInt;
    }

    //官方解法，有点冗余
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    //这个更好，java特有
    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

}
