/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // O(N)
    public ListNode partition(ListNode head, int x) {
        ListNode smallList = new ListNode(0);
        ListNode largeList = new ListNode(0);
        ListNode smallCur = smallList;
        ListNode largeCur = largeList;   
        
        while(head != null) {
            if (head.val < x) {
                smallCur.next = head;
                smallCur = smallCur.next;
            } else {
                largeCur.next = head;
                largeCur = largeCur.next;
            }
            head = head.next;
        }
        
        // Notice that to be carefull timeout in testing!!
        largeCur.next = null;
        
        // might be NULL or existed
        smallCur.next = largeList.next;
        
        // might be NULL or existed
        head = smallList.next;
        return head;
    }
    
    //O(N), but too many edge cases
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