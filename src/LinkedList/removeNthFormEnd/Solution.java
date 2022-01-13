package LinkedList.removeNthFormEnd;

import LinkedList.reversalLinkedList.Node;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public Node removeNthFormEnd(Node head, int n) {
        int length = getLength(head);
        Node prev = new Node(-1);
        prev.next = head;
        Node cur = prev;
        for (int i = 0; i <= length-n+1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return prev.next;
    }
    public int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public Node removeNthFormEndByStack(Node head, int n) {

        Node dump = new Node(-1);
        dump.next = head;
        Deque<Node> stack = new LinkedList<Node>();
        Node cur = dump;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        Node prev = stack.peek();
        prev.next = prev.next.next;
        return dump.next;
    }
}
