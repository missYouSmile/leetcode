package cn.belong.practice.list;

/**
 * leetcode: 206. Reverse Linked List
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode nextList = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextList;
        }

        head.next = null;
        return prev;
    }

    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        for (ListNode cur = head; cur != null; cur = cur.next) {
            ListNode tmp = dummyHead.next;
            ListNode curNode = new ListNode(cur.val);
            dummyHead.next = curNode;
            curNode.next = tmp;
        }
        return dummyHead.next;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode cur = this;
            StringBuilder builder = new StringBuilder();
            while (cur != null) {
                builder.append(cur.val).append(",");
                cur = cur.next;
            }
            return builder.toString();
        }
    }

}
