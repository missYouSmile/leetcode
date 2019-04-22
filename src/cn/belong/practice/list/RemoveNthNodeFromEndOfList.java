package cn.belong.practice.list;

import java.util.Stack;

/**
 * leetcode NO 19.  Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode delNode = null;
        for (int i = n; i > 0; i--) {
            delNode = stack.pop();
        }

        if (delNode == head)
            return delNode.next;

        ListNode prev = stack.pop();
        ListNode temp = delNode.next;
        prev.next = temp;
        delNode.next = null;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
