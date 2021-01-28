package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：CK
 * @date ：Created in 2020/10/27 9:10
 * @description：
 */
public class No144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if (treeNode != null){
                list.add(treeNode.val);
                stack.push(treeNode.right);
                stack.push(treeNode.left);
            }
        }
        return list;
    }
}
