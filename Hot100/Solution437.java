package Hot100;

/**
 * @author Jiang
 * @date 2020/4/4 22:53
 * <p>
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class Solution437 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int count;

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        helper2(root, sum);
        return count;
    }

    public void helper2(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        helper(root, sum, 0);
        helper2(root.left, sum);
        helper2(root.right, sum);
    }

    public void helper(TreeNode root, int sum, int current) {
        if (root == null) {
            return;
        }
        if (current + root.val == sum) {
            count++;
        }
        helper(root.left, sum, current + root.val);
        helper(root.right, sum, current + root.val);
    }
}
