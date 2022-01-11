package LinkedList.MiddleNode;

import LinkedList.reversalLinkedList.Node;

public class Solution {

    public ListNode middleNode(ListNode node) {
        ListNode[] A = new ListNode[100];
        int i = 0;
        while (node != null) {
            node = node.next;
            A[i++] = node;
        }
        return A[i/2];
    }

    public ListNode middleNodeByDoublePointer (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next == null) {
            return  slow.next;
        } else return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        try {
            ListNode listNode = new ListNode(arr);
            Solution solution = new Solution();
            ListNode res = solution.middleNodeByDoublePointer(listNode);
            System.out.println(res);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}