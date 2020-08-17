import java.util.Stack;

public class Leetcode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int val = stack1.pop() + stack2.pop() + carry;
            carry = val / 10;
            stack3.add(val % 10);
        }
        while (!stack1.isEmpty()) {
            int val = stack1.pop() + carry;
            carry = val / 10;
            stack3.add(val % 10);
        }
        while (!stack2.isEmpty()) {
            int val = stack2.pop() + carry;
            carry = val / 10;
            stack3.add(val % 10);
        }
        if (carry != 0) stack3.add(carry);
        ListNode head = new ListNode(stack3.pop());
        ListNode now = head;
        while (!stack3.isEmpty()) {
            now.next = new ListNode(stack3.pop());
            now = now.next;
        }
        return head;
    }
}
