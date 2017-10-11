package com.myleetcode;

import com.myleetcode.data.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode019 {
    public static void main(String[] args) {
        LeetCode019 obj = new LeetCode019();
        ListNode list = obj.removeNthFromEnd(ListNode.genListNode(new int[]{1, 2, 3, 4, 5, 6, 7}), 2);
        ListNode.printNodeList(list);
    }

    public static class Node {
        int index;
        ListNode curr;
        ListNode pre;
    }

    public ListNode removeNthFromEnd(ListNode list, int revIndex) {
        ListNode head = list;
        ListNode curr = list;
        ListNode pre = list;

        List<Node> array = new ArrayList<>();
        while (curr != null) {
            Node n = new Node();
            n.index = array.size();
            if (pre == curr) {
                n.curr = curr;
                n.pre = null;
            } else {
                n.curr = curr;
                n.pre = pre;
            }
            pre = curr;
            curr = curr.next;
            array.add(n);
        }
        if (array.size() - revIndex >= 0) {
            Node target = array.get(array.size() - revIndex);
            if (target.pre == null) {
                head = target.curr.next;
            } else if (target.curr.next == null) {
                target.pre.next = null;
            } else {
                target.pre.next = target.curr.next;
            }
        }
        return head;
    }
}
