package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：CK
 * @date ：Created in 2020/11/1 11:00
 * @description：
 */
public class No139 {
    //dp，每次从头开始判断是否能拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
