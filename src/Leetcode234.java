public class Leetcode234 {
    //O(n)时间复杂度，O(1)空间复杂度实现链表回文串判断
 /* 递归写法耗时太长
    private ListNode transverse(ListNode head) {//反转链表
        if (head == null || head.next == null) return head;
        ListNode pre = transverse(head.next);
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = head;
        return pre;
    }*/
    //反转链表
    private ListNode transverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode head2 = transverse(slow);
        while (head2 != null) {
            if (head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}
