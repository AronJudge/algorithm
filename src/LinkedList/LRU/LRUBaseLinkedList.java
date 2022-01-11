package LinkedList.LRU;

import java.util.Scanner;

public class LRUBaseLinkedList<T> {
    /**
     * LinkedList.LRU algorithm
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * head node.
     */
    private SNode<T> headNode;

    /**
     * Linked capacity
     */
    private Integer capacity;

    private Integer length;

    public static void main(String[] args) {
        LRUBaseLinkedList linkedList = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            linkedList.add(sc.nextInt());
            linkedList.printAll();
        }
    }

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);

        // Exists in the list of chains, deletes the original data and inserts it into the head of the list.
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                // delete last LinkedList.LRU.SNode.
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    private void deleteElemAtEnd() {
        SNode ptr = headNode;

        if (ptr.getNext() == null) {
            return;
        }

        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length-- ;
    }

 private void insertElemAtBegin(T data) {
        SNode sNode = headNode.getNext();
        headNode.setNext(new SNode(data,sNode));
        length ++;
    }

    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length --;
    }

    private SNode findPreNode(T data) {
        SNode sNode = headNode;
        while (sNode.getNext() != null) {
            if (data.equals(sNode.getNext().getElement())) {
                return sNode;
            }
            sNode = sNode.getNext();
        }
        return null;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }



}
