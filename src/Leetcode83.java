public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode pre = head, now = head.next;
        while (now != null) {
            if (now.val == pre.val) {
                pre.next = now.next;
                now = now.next;
            } else {
                pre = now;
                now = now.next;
            }
        }
        return head;
    }
}
