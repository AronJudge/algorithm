package LinkedList.Josephu;

public class CircleSingleLinkedList {

    // create fist node;
    private Boy first = new Boy(-1);

    // add node, create circle linkedList;
    public void addBoys(int nums) {
        if (nums < 1) {
            System.out.println("number incorrect");
            return;
        }
        Boy curBoy = null; // help to create a circle linkList;
        // use for looper create circle linked list
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // ergodic
    public void showBoys() {
        if (first == null) {
            System.out.println("linked List is null");
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("child's node%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 约瑟夫小孩出圈问题
     * 1.需要创建一个辅助指针helper，指向环形链表的最后一个结点（first的前一个）
     * 报数前：让first移动到开始报数startNo位置
     * helper移动到first前一个
     * ！！！！！！就是说：first，helper同时移动startNo -1 个位置
     * 2.当小孩报数是，让first和helper指针同时移动countNum-1次
     * 3.这时候可以将fiirst指向的小孩出圈
     * first = first.next;
     * helper.next = first;
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // @param startNo start location countNum,
        if (first == null || startNo < 1 || startNo > nums || nums < 0) {
            System.out.println("params incorrect");
        }

        // create helper to last
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {
                break;
            }
            // first, helper move countNum - 1
            for (int i = 0; i < countNum; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("child    " + first.getNo() + "    out of circle!!");

            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("the last in circle child is : %d \n", first.getNo());
    }
}
