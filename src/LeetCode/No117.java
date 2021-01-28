package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/28 9:11
 * @description：
 */
public class No117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
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
