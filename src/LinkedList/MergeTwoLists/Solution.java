package LinkedList.MergeTwoLists;

import LinkedList.reversalLinkedList.Node;
public class Solution {
    public Node mergeTwoList(Node l1, Node l2) {
        Node preHead = new Node(-1);
        Node pre = preHead;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public Node mergeTwoListByRecursion(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.value < l2.value) {
            l1.next = mergeTwoListByRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListByRecursion(l1,l2.next);
            return l2;
        }
    }
}
