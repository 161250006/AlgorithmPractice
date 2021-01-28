package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2020/9/16 10:07
 * @description：
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class No226 {

    //广搜
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode newRoot = new TreeNode(root.val);
        Queue<TreeNode> newQueue = new LinkedList<>();
        newQueue.offer(newRoot);
        while (!queue.isEmpty()){
            int k = queue.size();
            TreeNode treeNode;
            TreeNode newTreeNode;
            for (int i = 0 ; i < k ; i ++){
                 treeNode = queue.poll();
                 stack.push(treeNode.left);
                 stack.push(treeNode.right);
                 if (treeNode.left != null){
                     queue.offer(treeNode.left);
                 }
                if (treeNode.right != null){
                     queue.offer(treeNode.right);
                }
            }
            for (int i = 0 ; i < k ; i ++){
                newTreeNode = newQueue.poll();
                if (stack.peek() != null) {
                    newTreeNode.left = new TreeNode(stack.pop().val);
                    newQueue.offer(newTreeNode.left);
                }
                else {
                    newTreeNode.left = stack.pop();
                }
                if (stack.peek() != null) {
                    newTreeNode.right = new TreeNode(stack.pop().val);
                    newQueue.offer(newTreeNode.right);
                }
                else {
                    newTreeNode.right = stack.pop();
                }
            }
        }
        return newRoot;
    }

    //递归
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args){
        No226 no226 = new No226();
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        no226.invertTree(treeNode1);

    }
}
