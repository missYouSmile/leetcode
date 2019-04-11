package cn.belong.practice.list;

/**
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

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


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
