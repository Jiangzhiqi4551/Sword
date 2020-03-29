package Hot100;

import java.util.ArrayList;

/**
 * @author Jiang
 * @date 2020/3/29 22:21
 * <p>
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 */
public class Solution538 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // int num = 0;
    public TreeNode convertBST(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        helper(root, list);
        return root;

        // if(root == null){
        //     return root;
        // }
        // convertBST(root.right);
        // root.val += num;
        // num = root.val;
        // convertBST(root.left);
        // return root;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }

    public void helper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        int pos = list.indexOf(root.val);
        int count = root.val;
        for (int i = pos + 1; i < list.size(); ++i) {
            count = count + list.get(i);
        }
        root.val = count;
        helper(root.left, list);
        helper(root.right, list);
    }
}
