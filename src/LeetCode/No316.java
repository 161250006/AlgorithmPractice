package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2020/12/20 11:01
 * @description：
 */
public class No316 {
    //自己写的，没写出来，没有设置访问数组，而且用的是删除的方法，而不是一个个append，导致太复杂
    public String removeDuplicateLetters(String s) {
        Map<Character , Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i ++){
            char a = s.charAt(i);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int i = 0;
        while (i < stringBuilder.length()){
            char a = stringBuilder.charAt(i);
            if (map.get(a) > 1){
                if (a < stringBuilder.charAt(i+1)){
                    stack.push(a);
                }
                else if (a == stringBuilder.charAt(i+1)){
                    stack.push(a);
                    stringBuilder.deleteCharAt(i);
                    i--;
                }
                else {
                    stringBuilder.deleteCharAt(i);
                    i--;
                    map.put(a,map.get(a)-1);
                    while (!stack.isEmpty()){
                        a = stack.peek();
                        if (a > stringBuilder.charAt(i+1)){
                            stack.pop();
                            stringBuilder.deleteCharAt(i);
                            i--;
                            map.put(a,map.get(a)-1);
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            else if (map.get(a) == 1){
                while (!stack.isEmpty()){
                    a = stack.pop();
                }
            }
            else {
                stringBuilder.deleteCharAt(i);
                i--;
            }
            i++;
        }
        return stringBuilder.toString();
    }

    //用栈的思想，一个个加，而不是删，遇到前一个大于后一个的就一个个往前删，直到前一个小于后一个，注意设置访问数组，可以防止重复添加
    public String removeDuplicateLetters1(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
