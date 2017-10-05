package com.myleetcode;

import com.myleetcode.data.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode206 {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            data.add(i + 1);
        }
        LeetCode206 obj = new LeetCode206();
        {
            final ListNode head = ListNode.genListNode(data
                    .stream()
                    .mapToInt(i -> i)
                    .toArray());
            long start = System.currentTimeMillis();
            ListNode.printNodeList(obj.reverseList(head));
            System.out.println("#1, spend : " + (System.currentTimeMillis() - start));
        }

        {
            final ListNode head = ListNode.genListNode(data
                    .stream()
                    .mapToInt(i -> i)
                    .toArray());
            long start = System.currentTimeMillis();
            ListNode.printNodeList(obj.reverseListRecursive(head));
            System.out.println("#2, spend : " + (System.currentTimeMillis() - start));
        }

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode prev = null;
        while (p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode p = reverseListRecursive(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }

    }
}
