package LeetCode; /**
 * @author ：CK
 * @date ：Created in 2020/9/4 9:14
 * @description：
 */

import java.util.ArrayList;
import java.util.List;


public class No257 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list =new ArrayList<>();
        if(root != null){
            return search(root,Integer.toString(root.val),list);
        }
        else{
            return list;
        }
    }

    public List<String> search(TreeNode root, String path, List<String> load){
        if (root.left != null){
            search(root.left, path + "->" + Integer.toString(root.left.val), load);
        }
        if (root.right != null){
            search(root.right, path + "->" + Integer.toString(root.right.val), load);
        }
         if (root.left == null && root.right == null){
             load.add(path);
             return load;
         }
         return load;
    }
}
