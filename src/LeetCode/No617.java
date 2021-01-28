package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/23 9:49
 * @description：
 */
public class No617 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return null;
        }
        else if (t1 == null){
            t1 = new TreeNode(t2.val);
        }
        else if (t2 == null){
            t2 = new TreeNode(0);
        }
        else {
            t1.val += t2.val;
        }
        return dfs(t1,t2);

    }
    public TreeNode dfs(TreeNode t1, TreeNode t2){
        if (t1.left == null && t2.left != null){
            t1.left = new TreeNode(t2.left.val);
            dfs(t1.left , t2.left);
        }
        else if (t2.left != null){
            t1.left.val = t1.left.val + t2.left.val;
            dfs(t1.left , t2.left);
        }
        if (t1.right == null && t2.right != null){
            t1.right = new TreeNode(t2.right.val);
            dfs(t1.right , t2.right);
        }
        else if (t2.right != null){
            t1.right.val = t1.right.val + t2.right.val;
            dfs(t1.right , t2.right);
        }
        return t1;
    }
}
