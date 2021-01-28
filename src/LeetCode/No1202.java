package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2021/1/11 10:47
 * @description：
 */
public class No1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Div div = new Div(s.length());
        for (List<Integer> x : pairs){
            div.union(x.get(0),x.get(1));
        }
        //这边我觉得用优先队列更好
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i ++){
            int parent = div.find(i);
            if (map.containsKey(parent)){
                List<Character> list = map.get(parent);
                list.add(s.charAt(i));
            }
            else {
                List<Character> list = new ArrayList<>();
                list.add(s.charAt(i));
                map.put(parent , list);
            }
        }
        for (List<Character> list : map.values()){
            list.sort(Comparator.comparingInt(a -> a));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i ++){
            int parent = div.find(i);
            stringBuilder.append(map.get(parent).remove(0));
        }
        return stringBuilder.toString();
    }

    //这里可以加一个rank数组用来记录树中元素的个数，在合并时确保小树合并到大树中，防止左右子树过于不均衡
    class Div{
        public int[] parent;

        public Div(int len){
            parent = new int[len];
            for (int i = 0 ; i < len ; i ++){
                parent[i] = i;
            }
        }

        public void union(int x, int y){
            parent[find(x)] = find(y);
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
    }
}
