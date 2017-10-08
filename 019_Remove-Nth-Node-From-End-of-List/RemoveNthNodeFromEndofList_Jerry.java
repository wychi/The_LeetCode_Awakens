/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // move n and (size - n): one pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        while(n-- > 0) {
            curr = curr.next;
        }
        
        // nth is equeals to total size => got head one
        if (curr == null) {
            head = head.next;
            return head;
        }
        
        // Dummy one for prev with n+1 or execute one more time with (curr = curr.next)
        ListNode prev = new ListNode(0);
        prev.next = head;
        while(curr != null) {
            curr = curr.next;
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        return head;
    }
    
    public ListNode removeNthFromEnd_old(ListNode head, int n) {
        List<ListNode> record = new ArrayList<>();
        ListNode start = head;
        while (start != null) {
            record.add(start);
            start = start.next;
        }
        
        // first one
        if (n == record.size()) {
            head = head.next;
            return head;
        } else if (n < record.size()) {
            ListNode prevOne = record.get(record.size() - n - 1);
            prevOne.next = prevOne.next.next;
        }
        
        return head;        
    }
}