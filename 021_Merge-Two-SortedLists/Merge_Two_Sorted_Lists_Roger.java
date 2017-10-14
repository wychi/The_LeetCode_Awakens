/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode iter1 = l1, iter2 = l2;

        ListNode l3 = new ListNode(0);
        ListNode iter3 = l3;

        while (iter1 != null && iter2 != null) {
            if (iter1.val < iter2.val) {
                iter3.next = new ListNode(iter1.val);
                iter1 = iter1.next;
            } else {
                iter3.next = new ListNode(iter2.val);
                iter2 = iter2.next;
            }
            iter3 = iter3.next;
        }

        if (iter1 != null) {
            iter3.next = iter1;
        } else {
            iter3.next = iter2;
        }

        return l3.next;
    }
}
