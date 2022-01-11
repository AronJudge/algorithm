package LinkedList.reversalLinkedList;

public class reverseLinkedList {

    public Node reverseByRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public  Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
