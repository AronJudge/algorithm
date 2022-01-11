package LinkedList.MiddleNode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) throws IllegalAccessException {
        if (nums == null || nums.length == 0) {
            throw new IllegalAccessException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode cur = this;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("Null");
        return s.toString();
    }
}
