package LinkedList.reversalLinkedList;

public class Node {

     public int value;
     public Node next;

    public Node (int value, Node node) {
        this.value = value;
        this.next = node;
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node() {
        this.value = value;
        this.next = null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
