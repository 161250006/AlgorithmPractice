package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2021/1/21 16:14
 * @description：
 */
public class No17 {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return result;
        }
        List<Character>[] phone = new List[8];
        phone[0] = new ArrayList<Character>(Arrays.asList('a','b','c'));
        phone[1] = new ArrayList<Character>(Arrays.asList('d','e','f'));
        phone[2] = new ArrayList<Character>(Arrays.asList('g','h','i'));
        phone[3] = new ArrayList<Character>(Arrays.asList('j','k','l'));
        phone[4] = new ArrayList<Character>(Arrays.asList('m','n','o'));
        phone[5] = new ArrayList<Character>(Arrays.asList('p','q','r','s'));
        phone[6] = new ArrayList<Character>(Arrays.asList('t','u','v'));
        phone[7] = new ArrayList<Character>(Arrays.asList('w','x','y','z'));
        dfs(digits,new StringBuilder(),0, phone);
        return result;
    }

    public void dfs(String digits, StringBuilder stringBuilder , int index, List<Character>[] phone){
        if (index == digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        int x = digits.charAt(index) - '2';
        for (Character c : phone[x]){
            stringBuilder.append(c);
            dfs(digits, stringBuilder, index+1, phone);
            stringBuilder.deleteCharAt(index);
        }
    }
}
