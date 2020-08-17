import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//非递归实现二叉树的后序遍历
public class leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.add(root.val);
            if (root.left != null) s1.push(root.left);
            if (root.right != null) s1.push(root.right);
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop());
        }
        return res;
    }
}
