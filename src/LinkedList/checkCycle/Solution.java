package LinkedList.checkCycle;

import LinkedList.reversalLinkedList.Node;

import java.util.HashSet;

public class Solution {

    public Node detectCycle(Node head) {
        Node pos = head;
        HashSet<Node> set = new HashSet<Node>();
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public Node detectCycleByDoublePointer(Node head) {

        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;

            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }

        }
        return null;
    }
}
