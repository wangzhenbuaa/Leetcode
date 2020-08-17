public class leetcode109 {
    //时间超限了
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        if (head == null) return null;
        ListNode p1 = head, p2 = head;
        while (p2 != tail && p2.next != tail) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        TreeNode root = new TreeNode(p1.val);
        root.left = toBST(head, p1);
        root.right = toBST(p1.next, p2);
        return root;
    }
}
