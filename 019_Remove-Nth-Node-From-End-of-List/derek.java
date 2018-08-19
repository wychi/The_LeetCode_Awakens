//Keep gap between slow and fast pointer
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        slow.next = head;
        while (fast.next != null) {
            if (n<=0) 
                slow = slow.next;
            fast = fast.next;
            n--;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //Key: Keep gap 'N' fast pointer between slow pointer
    //Question: if head is null, what is expect answer ? null ?
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n < 0) {
            return null;
        }
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        start.next = head;
        
        for (int i = 0; i<=n; i++) {
            if (null != fast) {
                fast = fast.next;
            }
        }
        
        while (null != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        if (null != slow.next) {
            slow.next = slow.next.next;
        }
        
        return start.next;
    }
}
