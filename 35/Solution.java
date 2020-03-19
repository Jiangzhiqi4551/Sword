/**
 * @author Jiang
 * @date 2020/3/19 10:23
 * 复杂链表的复制
 */
public class Solution {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        Node current = head;
        Node next = current;

        while (current != null) {
            next = current.next;
            Node newNode = new Node(current.val);
            current.next = newNode;
            newNode.next = next;
            current = next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            } else {
                current.next.random = null;
            }
            current = current.next.next;
        }

        int count = 1;
        current = head;
        next = current.next;
        head.next = null;
        Node tmp = next.next;
        next.next = null;
        Node currentTail = current;
        Node nextTail = next;
        Node tmpNext = tmp;

        while (tmp!=null){
            tmpNext = tmp.next;
            tmp.next = null;
            if(count%2 == 1){
                currentTail.next = tmp;
                currentTail = tmp;
            }else{
                nextTail.next = tmp;
                nextTail = tmp;
            }
            count++;
            tmp = tmpNext;
        }

        return next;
    }
}
