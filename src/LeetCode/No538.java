package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/9/21 9:09
 * @description：
 */
public class No538 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode convertBST(TreeNode root) {
        sum(root, new ArrayList<>());
        return root;
    }
    public void sum(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        int sum = 0;
        list.add(root.val);
        sum(root.right, list);
        for (Integer a:list){
            if (a > root.val){
                sum = sum + a;
            }
        }
        sum(root.left,list);
        root.val = root.val + sum;
        return;
    }

    //反向中序遍历
    int sum = 0;
    public TreeNode convertBST2(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
