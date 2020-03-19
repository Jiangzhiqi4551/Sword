import java.util.Arrays;

/**
 * @author Jiang
 * @date 2020/3/19 12:03
 * 重建二叉树:输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 */
public class Solution07 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        if (n == 0) {
            return null;
        }

        int root = preorder[0];
        int rootIndex = 0;

        for (int i = 0; i < n; ++i) {
            if (inorder[i] == root) {
                rootIndex = i;
                break;
            }
        }

        TreeNode node = new TreeNode(root);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex),
                Arrays.copyOfRange(inorder, 0, rootIndex)
        );
        node.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n),
                Arrays.copyOfRange(inorder, rootIndex + 1, n)
        );
        return node;
    }
}
