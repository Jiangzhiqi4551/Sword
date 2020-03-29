package Hot100;

/**
 * @author Jiang
 * @date 2020/3/29 21:36
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class Solution543 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }

        helper(root);
        return max;

    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        if (leftDepth + rightDepth > max) {
            max = leftDepth + rightDepth;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
