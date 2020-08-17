public class Leetcode725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode now = root;
        int len = 0;
        while (now != null) {
            len++;
            now = now.next;
        }
        int numNodes = len / k;
        int numPlusOne = len % k;
        ListNode[] list = new ListNode[k];
        int idx = 0;
        while (idx < k && root != null) {
            list[idx] = root;
            System.out.println(root.val);
            int num = numNodes;
            if (numPlusOne > 0) {
                num++;
                numPlusOne--;
            }
            while (root != null && num > 1) {
                root = root.next;
                num--;
            }
            if (root == null) break;
            ListNode temp = root.next;
            root.next = null;
            root = temp;
            idx++;
        }
        return list;
    }
}
