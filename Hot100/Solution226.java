package Hot100;

/**
 * @author Jiang
 * @date 2020/4/4 21:48
 * <p>
 * 翻转一棵二叉树。
 */
public class Solution226 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
