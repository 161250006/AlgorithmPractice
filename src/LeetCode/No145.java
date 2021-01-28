package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2020/9/29 9:24
 * @description：
 */
public class No145 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //用双向队列，反向前序
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (null == root) return ans;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.addFirst(node.val);
            if (null != node.left) {
                stack.push(node.left);
            }
            if (null != node.right) {
                stack.push(node.right);
            }
        }
        return ans;
    }
}
