package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/11/25 14:30
 * @description：
 */
public class No222 {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left+right+1;
    }
}
