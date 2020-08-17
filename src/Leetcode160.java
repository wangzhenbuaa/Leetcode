public class Leetcode160 {
    //a+c+b = b+c+a
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode idx1 = headA, idx2 = headB;
        while (idx1 != idx2) {
            idx1 = idx1 == null ? headB : idx1.next;
            idx2 = idx2 == null ? headA : idx2.next;
        }
        return idx1;
    }
}
