package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/25 10:08
 * @description：
 */
public class No106 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length != 0) {
            return build(new TreeNode(postorder[postorder.length-1]), inorder, postorder,
                    0, inorder.length, 0, postorder.length);
        }
        return null;
    }
    public TreeNode build(TreeNode treeNode, int[] inorder, int[] postorder,
                          int begin1, int end1, int begin2, int end2){
        int now = 0;
        if (begin1 == end1 - 1){
            return treeNode;
        }
        for (int i = begin1 ; i < end1; i++){
            if (treeNode.val == inorder[i]){
                now = i;
                break;
            }
        }
        int lengthRight = end1 - now - 1;
        if (now > begin1) {
            treeNode.left = new TreeNode(postorder[end2 - 2 - lengthRight]);
            build(treeNode.left, inorder, postorder, begin1, now , begin2,end2 - 1 - lengthRight);
        }
        if (lengthRight > 0){
            treeNode.right = new TreeNode(postorder[end2 - 2]);
            build(treeNode.right, inorder, postorder, now + 1, end1, end2 - 1 - lengthRight, end2 - 1);
        }
        return treeNode;
    }
    public static void main(String[] args){
        No106 no106 = new No106();
        no106.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
    }
}
