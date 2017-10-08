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
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode st = small;
        ListNode lt = large;

        while(head != null) {
            if(head.val < x) {
                st.next = head;
                st = st.next;
            } else {
                lt.next = head;
                lt = lt.next;
            }
            
            head = head.next;
        }
        st.next = large.next;
        lt.next = null;
        return small.next;
    }
}
