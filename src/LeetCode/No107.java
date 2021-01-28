package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：CK
 * @date ：Created in 2020/9/6 10:22
 * @description：
 */


public class No107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private List<List<Integer>> lists;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        lists = new LinkedList<>();
        if (root == null){
            return lists;
        }
        Queue<Queue<TreeNode>> queueList = new LinkedList<Queue<TreeNode>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queueList.offer(queue);
        while (!queueList.isEmpty()){
            List<Integer> list = new ArrayList<>();
            queue = queueList.poll();
            Queue queue1 = new LinkedList();
            while (!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null){
                    queue1.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    queue1.offer(treeNode.right);
                }
            }
            lists.add(0,list);
            if (!queue1.isEmpty()){
                queueList.offer(queue1);
            }
        }
        return lists;
    }

}
