public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode slow = head, fast = head;
        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
       slow.next = slow.next.next;
        return head;
/*        if (head == null) return head;
        int numNode = 0;
        ListNode now = head;
        while (now != null) {
            numNode++;
            now = now.next;
        }
        if (numNode < n) return head;
        else if (numNode == n) return head.next;
        else {
            int cnt = 0;
            ListNode pre = head;
            now = head.next;
            while (cnt++ < numNode - n) {
                pre = now;
                now = now.next;
            }
            pre.next = now.next;
        }
        return head;*/
    }
}
