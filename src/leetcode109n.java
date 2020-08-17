public class leetcode109n {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        TreeNode root = new TreeNode(mid.val);
        preMid.next = null;//断开结点
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    //找到中间结点的前一结点
    public ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
