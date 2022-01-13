package Stack.LinkedStack;

import LinkedList.reversalLinkedList.Node;

public class StackBasedOnLinkedList {
    private Node top = new Node();

    public void push(int value) {
        Node newNode = new Node(value, null);
        top.next = newNode;
        top = newNode;
    }

    public int pop() {
        if (top == null) return -1;
        int value = top.value;
        top = top.next;
        return value;
    }

    public void printALl() {
        Node p = top;
        while (p != null) {
            System.out.println(p.value + "");
            p = p.next;
        }
        System.out.println();
    }


}
