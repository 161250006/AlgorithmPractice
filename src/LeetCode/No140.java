package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2020/11/1 10:16
 * @description：
 */
public class No140 {
    private List<String> result;
    //自己写的，超时，可以先用139的dp判断，再搜索
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        dfs(s,0,"", wordDict);
        return result;
    }
    void dfs(String s, int i, String string, List<String> wordDict){
        if (i >= s.length()){
            result.add(string);
        }
        StringBuilder k = new StringBuilder();
        for (int j = i ; j < s.length() ; j ++){
            k.append(s.charAt(j));
            if (contains(k.toString(),wordDict)){
                if (string.isEmpty()){
                    dfs(s, j + 1, k.toString(), wordDict);
                }
                else {
                    dfs(s, j + 1, string + " " + k, wordDict);
                }
            }
        }
    }
    public boolean contains(String k, List<String> wordDict){
        for (String s : wordDict){
            if (s.equals(k)){
                return true;
            }
        }
        return false;
    }

    //记忆化搜索，减少了时间复杂度，相当于建立了一个缓存
    public List<String> wordBreak1(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}
