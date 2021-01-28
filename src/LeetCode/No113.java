package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/9/26 9:57
 * @description：
 */
public class No113 {
    private List<List<Integer>> lists;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>(), 0);
        return lists;
    }
    public void dfs(TreeNode root, int sum, int k, List<Integer> list, int i){
        if (root == null){
            return;
        }
        list.add(root.val);
        if (k + root.val == sum && root.left == null && root.right == null){
            lists.add(new ArrayList<>(list));
            list.remove(i);
            return;
        }
        if (root.left != null){
            dfs(root.left, sum, k+root.val, list,i+1);
        }
        if (root.right != null){
            dfs(root.right, sum, k+root.val, list,i+1);
        }
        list.remove(i);
        return;
    }
}
