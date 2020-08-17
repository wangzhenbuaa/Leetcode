//p判断链表是否有环，一个指针每次移动一个节点，另一个指针每次移动两个节点
public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode point1 = head, point2 = head;
        while (point1 != null && point2 != null && point2.next != null) {
            point1 = point1.next;
            point2 = point2.next.next;
            if (point1 == point2) return true;
        }
        return false;
    }
}
