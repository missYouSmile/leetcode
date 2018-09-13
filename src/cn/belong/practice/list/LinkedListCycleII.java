package cn.belong.practice.list;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO. 142
 *
 * @author shiwen.chen
 * @date 2018-09-13 11:32
 */
public class LinkedListCycleII {

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * Note: Do not modify the linked list.
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        if (head == head.next)
            return head;

        Map<ListNode, Integer> times = new HashMap<>();

        ListNode cur = head;

        while (cur != null) {
            if (times.get(cur) != null) {
                return cur;
            }
            times.put(cur, 1);
            cur = cur.next;
        }

        return null;
    }


    public ListNode detectCycle2(ListNode head) {

        ListNode cur = head;

        while (cur != null) {
            ListNode slow = cur;
            ListNode fast = cur;
            while (slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == cur || fast == cur)
                    return cur;
                if (slow == fast)
                    break;
            }
            cur = cur.next;
        }

        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Test
    public void test() {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        ListNode tail = new ListNode(-4);
        head.next.next.next = tail;
        tail.next = head.next;
        ListNode listNode = detectCycle2(head);
        System.out.println(listNode);

    }

}
