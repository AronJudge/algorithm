package queue;

import LinkedList.reversalLinkedList.Node;

public class LinkedQueue {
    Node head = null;
    Node tail = null;

    public LinkedQueue () {
    }

    public void enqueue(Node node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public int  dequeue() {
        if (head == null) return 0;

        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

}
