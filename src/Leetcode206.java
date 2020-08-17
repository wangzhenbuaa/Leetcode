public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, post;
        while (head != null) {
            post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }
}
