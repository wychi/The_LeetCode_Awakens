/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode result=null;
        while(head != null) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }
}