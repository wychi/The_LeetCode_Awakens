/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        if (n < 2) return true;
        temp = head; head = head.next;
        ListNode temp2;
        for (int i = 1; i<n/2; i++) {
            temp2 = head.next;
            head.next = temp;
            temp = head;
            head = temp2;
        }
        if (n%2 !=0) head = head.next;
        while (head != null && temp != null) {
            if (head.val != temp.val) return false;
            head = head.next; temp = temp.next;
        }
        return true;
    }
}