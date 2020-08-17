public class Leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head.next;
        ListNode head2 = p2;
        while (p2 != null && p2.next != null) {
            p1.next = p1.next.next;
            p1 = p1.next;
            p2.next = p2.next.next;
            p2 = p2.next;
        }
        p1.next = head2;
        return head;
    }
}
