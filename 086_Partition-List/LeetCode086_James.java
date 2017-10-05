package com.myleetcode;

import com.myleetcode.data.ListNode;

public class LeetCode086 {

    public static void main(String[] args) {
        // write your code here
        final ListNode list = ListNode.genListNode(new int[]{1, 1});
        LeetCode086 obj = new LeetCode086();
        ListNode.printNodeList(obj.partition(list, 0));
        ListNode.printNodeList(list);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = null;
        ListNode big = null;
        ListNode p = head;
        ListNode smallP = null;
        ListNode bigP = null;
        while (p != null) {
            if (p.val < x) {
                if (small == null) {
                    small = new ListNode(p.val);
                    smallP = small;
                } else {
                    smallP.next = new ListNode(p.val);
                    smallP = smallP.next;
                }
            } else {
                if (big == null) {
                    big = new ListNode(p.val);
                    bigP = big;
                } else {
                    bigP.next = new ListNode(p.val);
                    bigP = bigP.next;
                }
            }
            p = p.next;

        }
        if (small == null) {
            return big;
        } else if (big == null) {
            return small;
        } else {
            smallP.next = big;
            return small;
        }

    }
}
