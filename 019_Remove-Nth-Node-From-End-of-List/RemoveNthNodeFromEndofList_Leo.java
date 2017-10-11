class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy, cursor = dummy;
        for (int i = 0; i < n ; i++) tail = tail.next;
        while (null != tail.next) {
            cursor = cursor.next;
            tail = tail.next;
        }
        ListNode removed = cursor.next;
        cursor.next = removed.next;
        removed.next = null;
        return dummy.next;
    }
}
