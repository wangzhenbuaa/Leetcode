
public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head.next;
        head.next = swapPairs(pre.next);
        pre.next = head;
        return pre;
    }
}
