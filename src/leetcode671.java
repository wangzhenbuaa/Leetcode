import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class leetcode671 {
    Set<Integer> ans = new HashSet<>();
    Queue<Integer> res = new PriorityQueue<>();

    public int findSecondMinimumValue(TreeNode root) {
        transverse(root);
        if (ans.size() < 2) return -1;
        for (int i : ans) {
            res.add(i);
        }
        res.poll();
        return res.peek();
    }

    public void transverse(TreeNode root) {
        if (root == null) return;
        //所有叶结点即存储了所有结点的值
        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }
        transverse(root.left);
        transverse(root.right);
    }

}
