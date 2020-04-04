package Hot100;

/**
 * @author Jiang
 * @date 2020/4/4 22:14
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Solution160 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        int countA = 0;
        int countB = 0;
        ListNode aTmp = headA;
        ListNode bTmp = headB;

        while (aTmp != null) {
            countA++;
            aTmp = aTmp.next;
        }
        while (bTmp != null) {
            countB++;
            bTmp = bTmp.next;
        }

        ListNode longNode, shortNode;
        int diff = 0;

        if (countA > countB) {
            longNode = headA;
            shortNode = headB;
            diff = countA - countB;
        } else {
            longNode = headB;
            shortNode = headA;
            diff = countB - countA;
        }

        while (diff > 0) {
            longNode = longNode.next;
            diff--;
        }

        while (longNode != null) {
            if (longNode == shortNode) {
                break;
            } else {
                longNode = longNode.next;
                shortNode = shortNode.next;
            }
        }

        return longNode;
    }
}
