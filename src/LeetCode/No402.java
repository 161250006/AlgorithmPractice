package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：CK
 * @date ：Created in 2020/11/15 11:07
 * @description：
 */
public class No402 {
    public String removeKdigits(String num, int k) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder(num);
        while (i >= 0 && i < stringBuilder.length() - 1 && k > 0) {
            if (stringBuilder.charAt(i) > stringBuilder.charAt(i + 1)) {
                stringBuilder.deleteCharAt(i);
                k --;
                if (i > 0 && stringBuilder.charAt(i-1) > stringBuilder.charAt(i)){
                    i--;
                }
            }
            else {
                i++;
            }
        }
        i = stringBuilder.length() - 1;
        while (k > 0) {
            stringBuilder.deleteCharAt(i);
            i--;
            k--;
        }
        while (stringBuilder.length() > 0 && (stringBuilder.charAt(0) == '0')){
            stringBuilder.deleteCharAt(0);
        }
        if (stringBuilder.length() == 0){
            return "0";
        }
        else {
            return stringBuilder.toString();
        }
    }

    //贪心+单调栈，用栈储存之前访问过的数字
    public String removeKdigits1(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
