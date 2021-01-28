package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/19 10:52
 * @description：
 */
public class No404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int l = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            l = root.left.val;
        }
        return l + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
