package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/10/29 10:04
 * @description：
 */
public class No129 {
    private List<Integer> integers;
    public int sumNumbers(TreeNode root) {
        integers = new ArrayList<>();
        if (root == null){
            return 0;
        }
        dfs(root , 0);
        int sum = 0;
        for (int i:integers){
            sum += i;
        }
        return sum;
    }
    public void dfs(TreeNode root , int k){
        k = k * 10 + root.val;
        if (root.left == null && root.right == null){
            integers.add(k);
            return;
        }
        if (root.left != null){
            dfs(root.left , k);
        }
        if (root.right != null){
            dfs(root.right , k);
        }
    }
}
