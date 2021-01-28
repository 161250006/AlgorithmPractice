package LeetCode;

import common.Node;

/**
 * @author ：CK
 * @date ：Created in 2020/10/15 10:50
 * @description：
 */
//117相似
public class No116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node now = root;
        Node child = null;
        Node start = root;
        while (start != null){
            now = start;
            start = null;
            while (now != null){
                if (now.left != null){
                    if (start == null){
                        child = now.left;
                        start = now.left;
                    }
                    else {
                        child.next = now.left;
                        child = child.next;
                    }
                }
                if (now.right != null){
                    if (start == null){
                        child = now.right;
                        start = now.right;
                    }
                    else {
                        child.next = now.right;
                        child = child.next;
                    }
                }
                now = now.next;
            }
        }
        return root;
    }
}
