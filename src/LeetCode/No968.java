package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/22 9:24
 * @description：
 */

public class No968 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //递归+dp思想，离谱
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }

    //递归，好理解多了
    //0=>这个结点待覆盖
    //1=>这个结点已经覆盖
    //2=>这个结点上安装了相机
    public int minCameraCover2(TreeNode root) {
        if (lrd(root) == 0) {
            res++;
        }
        return res;
    }

    int res=0;
    int lrd(TreeNode node) {

        if (node == null) {
            return 1;
        }
        int left=lrd(node.left);
        int right=lrd(node.right);
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        if(left==1&&right==1){
            return 0;
        }
        if(left+right>=3){
            return 1;
        }

        return -1;
    }
}
