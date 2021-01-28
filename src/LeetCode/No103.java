package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/12/22 13:40
 * @description：
 */
public class No103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null){
            return result;
        }
        deque.addFirst(root);
        boolean k = false;
        while (!deque.isEmpty()){
            List<TreeNode> list = new ArrayList<>();
            List<Integer> resultList = new ArrayList<>();
            list.clear();
            k = !k;
            if (k) {
                while (!deque.isEmpty()) {
                    resultList.add(deque.peekFirst().val);
                    list.add(deque.removeFirst());
                }
            }
            else {
                list.addAll(deque);
                while (!deque.isEmpty()) {
                    resultList.add(deque.removeLast().val);
                }
            }
            result.add(resultList);
            for (TreeNode treeNode : list){
                if (treeNode.left != null){
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    deque.addLast(treeNode.right);
                }
            }
        }
        return result;
    }
}
