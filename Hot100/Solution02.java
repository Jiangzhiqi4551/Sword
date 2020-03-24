package Hot100;

/**
 * @author Jiang
 * @date 2020/3/24 14:44
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution02 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode cur = result;
        ListNode p = l1;
        ListNode q = l2;
        int add = 0;
        while (p != null || q != null || add != 0) {
            int pNum = (p == null) ? 0 : p.val;
            int qNum = (q == null) ? 0 : q.val;
            int sum = pNum + qNum + add;
            add = sum / 10;

            ListNode tmp = new ListNode(sum % 10);
            cur.next = tmp;
            cur = tmp;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        return result.next;
    }
}
