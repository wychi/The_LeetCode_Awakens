/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    //TODO might improve?
    public ListNode partition(ListNode head, int x) {
        ListNode curr = null, large_prev = null, large_start = null, large_end = null;
        
        curr = head;
        while(curr != null) {
            if (curr.val < x) {
                if (large_start == null) {
                    large_prev = curr;
                } else {  //have large record
                    if (large_prev == null) {
                        head = curr;
                    } else {
                        large_prev.next = curr; 
                    }
                    large_prev = curr;
                    
                    large_end.next = curr.next;
                    curr.next = large_start;
                        
                    curr = large_end;
                }
            } else {
                if (large_start == null) {
                    large_start = curr;
                }
                large_end = curr;
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}