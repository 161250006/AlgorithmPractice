package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2020/9/11 10:07
 * @description：
 */
public class No216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, n, path, res, k);
        return res;
    }
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res, int k) {
        if (k == 0 || target <= 0){
            if (target == 0 && k == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            return;
        }
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况


        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i+1 , len, target - candidates[i], path, res, k-1);
            path.removeLast();
        }
    }
}
