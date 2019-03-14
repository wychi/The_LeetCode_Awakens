/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //Recursive
    //Time: O(N)
    //Space:O(N) - recursive stack
    // public ListNode swapPairs(ListNode head) {
    //     if (head == null || head.next == null) return head;
    //     ListNode n = head.next;
    //     head.next = swapPairs(head.next.next);
    //     n.next = head;
    //     return n;
    // }
    
    //Iterative
    //Time: O(N)
    //Space:O(1)
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(0);
        ListNode prev = dummyNode;
        prev.next = head;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }
        return dummyNode.next;
    }
}
