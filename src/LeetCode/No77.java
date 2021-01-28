package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/9/8 10:00
 * @description：
 */
public class No77 {
    private List<List<Integer>> lists;
    public List<List<Integer>> combine(int n, int k) {
        lists = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<Integer>());
        return lists;
    }
    public void dfs(int n,int k,int i,List<Integer> list){
        if (k == list.size()){
            List<Integer> result = new ArrayList<>(list);
            lists.add(result);
            return;
        }
        for (int j = i;j <=  n - (k - list.size()) + 1; j++){
            list.add(j);
            dfs(n, k, j+1, list);
            list.remove((Integer)j);
        }
    }
}
