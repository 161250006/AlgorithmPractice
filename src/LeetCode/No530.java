package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/12 9:06
 * @description：
 */
//同No783
public class No530 {

    private int sum;
    private TreeNode p;
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        sum = Integer.MAX_VALUE;
        getMin(root);
        return sum;
    }
    public void getMin(TreeNode root){
        if (root == null){
            return;
        }
        getMin(root.left);
        if (p != null){
            sum = Math.min(sum, root.val-p.val);
        }
        p = root;
        getMin(root.right);
    }
}
