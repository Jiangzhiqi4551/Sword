import java.util.logging.Level;

/**
 * @author Jiang
 * @date 2020/3/19 14:35
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Solution36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node head;
    private Node pre;

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inOrder(Node root) {

        if (root == null) return;
        inOrder(root.left);
        root.left = pre;
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        pre = root;
        inOrder(root.right);

    }
}
