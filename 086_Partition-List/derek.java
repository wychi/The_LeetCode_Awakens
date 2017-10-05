/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        //Key: Use two list to sperate it
        ListNode smallList = new ListNode(0);
        ListNode largerList = new ListNode(0);
        ListNode curSmall = smallList, curLarger = largerList;
        
        while (null != head) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarger.next = head;
                curLarger = curLarger.next;
            }
            head = head.next;
        }
        curLarger.next = null;
        curSmall.next = largerList.next;
        return smallList.next;
    }
}
