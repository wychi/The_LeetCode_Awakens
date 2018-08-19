//Time: O(M+N)
//Space: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = null == l1 ? l2 : l1;
        // while (l1 != null) {
        //     ListNode newNode = new ListNode(l1.val);
        //     dummy.next = newNode;
        //     dummy = dummy.next;
        // }
        // while (l2 != null) {
        //     ListNode newNode = new ListNode(l2.val);
        //     dummy.next = newNode;
        //     dummy = dummy.next;
        // }
        return dummyHead.next;
    }
}
