package cn.belong.practice.list;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO. 92
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        int index = 1;
        ListNode cur = head;
        ListNode prefix = null;
        while (index < m) {
            prefix = cur;
            cur = cur.next;
            index++;
        }

        ListNode nh = cur;
        ListNode prev = null;
        while (index++ <= n) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        if (nh != null) {
            nh.next = cur;
        }

        if (prefix != null) {
            prefix.next = prev;
            return head;
        }

        return prev;
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

    @Test
    public void reverseBetween() {
        ListNode list = new ListNode(1);
        ListNode cur = list;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode listNode = reverseBetween(list, 1, 4);
        System.out.println(listNode);
    }

}
