/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count  = 0;
        Map<Integer, ListNode> maps = new HashMap<>();
        ListNode start = head;
        do {
            maps.put(count, start);
            start = start.next;
            count++;
        } while (start != null);
        if (count == n) {
            if (n==1) {
                return null;
            } else {
                return maps.get(1);
            }
        }
        ListNode next = (n==1 ? null : maps.get(count -n +1));
        maps.get(count-n-1).next = next;
        return maps.get(0);
    }
}